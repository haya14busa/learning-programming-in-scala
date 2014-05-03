import math.{E, Pi}

object VarConstPatterns {

  val pi = math.Pi
  def describe(x: Any) = x match {
    case Pi => "strange math? Pi = " + Pi
    case _ => "OK"
  }
  def describe2(x: Any) = x match {
    case pi => "strange math? Pi = " + pi
    // case _ => "OK" // unreachable code
  }
  def describe3(x: Any) = x match {
    case `pi` => "strange math? Pi = " + pi
    case _ => "OK" // unreachable code
  }
  def main(args: Array[String]) {

    println(describe(E))

    println(describe2(E))

    println(describe3(E))
    println("All done!")
  }
}
