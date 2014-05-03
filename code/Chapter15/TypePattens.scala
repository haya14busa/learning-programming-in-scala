object TypePattens {
  def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  }
  def main(args: Array[String]) {
    println(generalSize("abc"))
    println(generalSize(Map(1 -> 'a', 2 -> 'b')))
    println(generalSize(math.Pi))
  }
}
