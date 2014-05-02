import org.scalatest.Spec
import org.scalatest._
import Element.elem

// class ElementSuite extends Suite {
class ElementSpec extends Spec {
  def testUniformElement() = {
    val ele = elem('x', 2, 3)
    // assert(ele.width == 3)
    // assert(ele.width == 2)
  }
}
