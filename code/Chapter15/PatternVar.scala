object PatternVar {
  def main(args: Array[String]) {
    val exp = BinOp("*", Number(5), Number(1))
    val BinOp(op, left, right) = exp
    println(op)
    println(left)
    println(right)
  }
}
