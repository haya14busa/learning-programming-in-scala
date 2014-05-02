class Frog extends Philosophical {
  override def toString = "green"
}

object Frog {
  def main(args: Array[String]) {
    val frog = new Frog
    frog.philosophize()
    println(frog)

    val phil: Philosophical = frog
    phil.philosophize()
  }
}
