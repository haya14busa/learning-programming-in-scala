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

package org.stairwaybook.simulation


object Test extends CircuitSimulation with Application {

  val InverterDelay = 1
  val AndGateDelay = 3
  val OrGateDelay = 5

  def readOut(w: Wire) = if (w.getSignal) 1 else 0
  def bool(x: Int) = if (x == 0) false else true
  
  def invertTest() {
    val ain, cout = new Wire
    inverter(ain, cout)
    def result = readOut(cout)
    
    def test(a: Int) {
      ain setSignal bool(a)
      run()
      println("!"+a+" = "+result+"\n")
    }
    probe("out  ", cout)
    test(0)
    test(1)
  }

  def andTest() {
    val ain, bin, cout = new Wire
    andGate(ain, bin, cout)
    def result = readOut(cout)

    def test(a: Int, b: Int) {
      ain setSignal bool(a)
      bin setSignal bool(b)
      run()
      println(a+" & "+b+" = "+result+"\n")
    }
    probe("out  ", cout)
    test(0,0)
    test(0,1)
    test(1,0)
    test(1,1)
  }

  def orTest() {
    val ain, bin, cout = new Wire
    orGate(ain, bin, cout)
    def result = readOut(cout)

    def test(a: Int, b: Int) {
      ain setSignal bool(a)
      bin setSignal bool(b)
      run()
      println(a+" | "+b+" = "+result+"\n")
    }
    probe("out  ", cout)
    test(0,0)
    test(0,1)
    test(1,0)
    test(1,1)
  }

  def halfTest() {
    val ain, bin, sout, cout = new Wire
    halfAdder(ain, bin, sout, cout)

    def result = readOut(sout) + readOut(cout) * 2

    def test(a: Int, b: Int) {
      ain setSignal bool(a)
      bin setSignal bool(b)
      run()
      println(a+" + "+b+" = "+result+"\n")
    }

    probe("sum  ", sout)
    probe("carry", cout)
    test(0,0)
    test(0,1)
    test(1,0)
    test(1,1)
  }

  def fullTest() {
    val ain, bin, cin, sout, cout = new Wire
    fullAdder(ain, bin, cin, sout, cout)

    def result = readOut(sout) + readOut(cout) * 2

    def test(a: Int, b: Int, c: Int) {
      ain setSignal bool(a)
      bin setSignal bool(b)
      cin setSignal bool(c)
      run()
      println(a+" + "+b+" + "+c+" = "+result+"\n")
    }

    probe("sum  ", sout)
    probe("carry", cout)
    test(0,0,0)
    test(0,0,1)
    test(0,1,0)
    test(0,1,1)
    test(1,0,0)
    test(1,0,1)
    test(1,1,0)
    test(1,1,1)
  }

  invertTest()
  andTest()
  orTest()
  halfTest()
  fullTest()
}
