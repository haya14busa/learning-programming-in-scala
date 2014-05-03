object SealedExprSuite {
  def describe2(e: Expr): String = (e: @unchecked) match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }
  def describe(e: Expr): String = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }
  def main(args: Array[String]) {
  }
}
