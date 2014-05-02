class Outer {
  class Inner {
    private def f() = { println("f") }
    class InnerMost {
      f() // OK
    }
  }
  (new Inner).f() // Error
}
