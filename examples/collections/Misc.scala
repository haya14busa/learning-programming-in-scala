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

object Misc {
  object Obj1 {
    import scala.collection.mutable
    
    val synchroSet =
      new mutable.HashSet[Int] with
          mutable.SynchronizedSet[Int]
  }

  val tuple1 =
    (1, "hello", Console)
  
  def main(args: Array[String]) {
    println("Obj1.synchroSet [" + Obj1.synchroSet + "]")
    println("tuple1 [" + tuple1 + "]")
  }
}
