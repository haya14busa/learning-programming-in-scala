class Animal
trait HasLegs
class Frog2 extends Animal
            with Philosophical
            with HasLegs {
  override def toString = "green"
  override def philosophize() = {
    println("It ain't easzy being " + toString + "!")
  }
}


object TraitsTest {
  def main(args: Array[String]) {
    val frog = new Frog
    frog.philosophize()

    val frog2 = new Frog2
    frog2.philosophize()
  }
}
