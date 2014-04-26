abstract class Element {
  def demo() = {
    println("Element's implementation invoked")
  }
}

// final class ArrayElement extends Element {
class ArrayElement extends Element {
  // final override def demo() = { // Error
  override def demo() = {
    println("ArrayElement's implementation invoked")
  }
}

class LineElement extends ArrayElement {
  override def demo() = {
    println("LineElement's implementation invoked")
  }
}

class UniformElement extends Element

def invokeDemo(e: Element) = {
  e.demo
}

invokeDemo(new ArrayElement)
invokeDemo(new LineElement)
invokeDemo(new UniformElement)
