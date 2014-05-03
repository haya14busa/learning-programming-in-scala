object WithDefault {
  val withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }
  def main(args: Array[String]) {
    println(withDefault(Some(10)))
    println(withDefault(Some(0)))
    println(withDefault(None))
  }
}
