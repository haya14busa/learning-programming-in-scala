// File: Summer2.scala
import ChecksumAccumulator.calculate

object Summer2 extends App{
  for(arg <- args) {
    println(arg + ": " + calculate(arg))
  }
}
