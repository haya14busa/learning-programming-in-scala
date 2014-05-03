object VarBindPattens {
  def d(x: Any) = x match {
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case _ =>
  }
  def main(args: Array[String]) {
    println(d(UnOp("abs", UnOp("abs", Var("x")))))
    println(d(UnOp("+", UnOp("+", Var("x")))))
  }
}
