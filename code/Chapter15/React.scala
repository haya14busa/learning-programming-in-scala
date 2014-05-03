import scala.actors._
import scala.actors.Actor._

object React {
  def main(args: Array[String]) {
    react {
      case (name: String, actor: Actor) => {
        // actor ! getip(name)
        // act()
      }
      case msg => {
        println("Unhandled message: " + msg)
        // act()
      }
    }
  }
}
