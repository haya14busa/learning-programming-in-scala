object VariablePatterns {
  def describe(x: Any) = x match {
    case 0 => "0"
    case somethingElse => "not zero: " + somethingElse
  }

  def main(args: Array[String]) {
    println(describe(0))
    println(describe(1))
    println("All done!")
  }
}
