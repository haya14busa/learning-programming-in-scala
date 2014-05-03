object SimplifyAll {
  def simplifyAll(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) =>
      simplifyAll(e)
    case BinOp("+", e, Number(0)) =>
      simplifyAll(e)
    case BinOp("*", e, Number(1)) =>
      simplifyAll(e)
    case UnOp(op, e) =>
        UnOp(op, simplifyAll(e))
    case BinOp(op, l, r) =>
      BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
  }
  // unreachable code
  // def simplifyBad(expr: Expr): Expr = expr match {
  //   case UnOp(op, e) => UnOp(op, simplifyBad(e))
  //   case UnOp("-", UnOp("-", e)) => e
  // }
  def main(args: Array[String]) {
    println("Vim")
  }
}
