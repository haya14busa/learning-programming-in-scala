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
  def misc1() {
    val someNumbers = List(-11, -10, -5, 0, 5, 10)

    someNumbers.foreach(println _)

    someNumbers.foreach(x => println(x))

    someNumbers.foreach(println _)

    someNumbers.foreach(println)

  }

  def isEven(x: Int): Boolean =
    if (x == 0) true else isOdd(x - 1)
  def isOdd(x: Int): Boolean =
    if (x == 0) false else isEven(x - 1)

  val funValue = nestedFun _
  def nestedFun(x: Int) { 
    if (x != 0) { println(x); funValue(x - 1) }
  }

  def main(args: Array[String]) {
    misc1()
    
    println("gcbx isEven(2) [" + isEven(2) + "]")
    nestedFun(2)
  }
}
