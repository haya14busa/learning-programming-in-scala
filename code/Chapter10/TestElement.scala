import Element.elem

object TestElement {
  def main(args: Array[String]) {
    println(elem(Array("vim" , "emacs")))

    println("=" * 40)
    println(
      elem(Array("hello")) above
      elem(Array("world!"))
    )

    println("=" * 40)
    println(
      elem(Array("one", "two")) beside
      elem(Array("one"))
    )

    println("=" * 40)
    val column1 = elem("hello") above elem("***")
    val column2 = elem("***") above elem("world")
    println(
      column1 beside column2
    )

  }
}
