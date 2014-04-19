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

  class Rational(private val numer: Int, private val denom: Int) {

    def this(n: Int) = this(n, 1)

    def add(that: Rational): Rational =
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      )

    def sub(that: Rational): Rational =
      new Rational(
        numer * that.denom - that.numer * denom, 
        denom * that.denom
      )

    def mul(that: Rational): Rational =
      new Rational(numer * that.numer, denom * that.denom)

    def div(that: Rational): Rational =
      new Rational(numer * that.denom, denom * that.numer)

    override def toString() = numer+"/"+denom
  }

