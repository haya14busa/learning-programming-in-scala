object TuplePatterns {
  def tupleDemo(expr: Any) = expr match {
    case (a, b, c) => println("matched " + a + b + c)
    case _ =>
  }
  def main(args: Array[String]) {
    tupleDemo(("a ", 3, "-tuple"))
  }
}
