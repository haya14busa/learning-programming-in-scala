object ExprSuite {
  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _ => expr
  }
  def main(args: Array[String]) {
    val v = Var("x")
    val op = BinOp("+", Number(1), v)
    println(op)

    println(v.name)
    println(op.left)

    println(op.right == Var("x"))

    println(op.copy(operator = "-"))

    println(simplifyTop(UnOp("-", UnOp("-", Var("x")))))

  }
}
