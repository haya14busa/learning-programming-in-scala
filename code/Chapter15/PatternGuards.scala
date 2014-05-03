object PatternGuards {
  def simplifyAdd(e: Expr) = e match {
    case BinOp("+", x, y) if x == y =>
      BinOp("*", x, Number(2))
    case _ => e
  }
  def main(args: Array[String]) {
    println(simplifyAdd(BinOp("+", Var("x"), Var("x"))))
  }
}
