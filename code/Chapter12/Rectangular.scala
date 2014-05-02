class Point(val x: Int, val y: Int)

trait Rectangular {
  def topLeft: Point
  def bottomRight: Point
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // And more!
}

abstract class Component extends Rectangular {
  // Othrer methods
}

class Rectangle(val topLeft: Point, val bottomRight: Point)
  extends Rectangular {
  //
}

object Rectangle {
  def main(args: Array[String]) {
    val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
    println("Left: " + rect.left)
    println("Width: " + rect.width)
  }
}
