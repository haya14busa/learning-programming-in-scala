/*
 * Copyright (C) 2007-2010 Artima, Inc. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Example code from:
 *
 * Programming in Scala, Second Edition
 * by Martin Odersky, Lex Spoon, Bill Venners
 *
 * http://booksites.artima.com/programming_in_scala_2ed
 */

import java.io.PrintWriter
import java.util.Date
import java.net.ServerSocket

object LoanPattern {
  def using[T <: { def close(): Unit }, S](obj: T)
      (operation: T => S) = {
    val result = operation(obj)
    obj.close()
    result
  }

  def main(args: Array[String]) {
    using(new PrintWriter("date.txt")) { writer =>
      writer.println(new Date)
    }

    using(new ServerSocket(9999)) { serverSocket =>
      println("listening on port 9999....")

      using(serverSocket.accept()) { socket =>
        socket.getOutputStream().write("hello, world\n".getBytes)
      }
    }
  }
}
