object ConstantPatterns {
  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  }

  def main(args: Array[String]) {
    assert(describe(5) == "five")
    assert(describe(true) == "truth")
    assert(describe("hello") == "hi!")
    assert(describe(Nil) == "the empty list")
    assert(describe(List(1,2,3)) == "something else")
    println("All done!")
  }
}


