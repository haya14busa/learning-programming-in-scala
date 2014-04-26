// With by-name parameter
var assertionEnabled = true
def byNameAssert(predicate: => Boolean) = {
  if (assertionEnabled && !predicate) {
    throw new AssertionError
  }
}

def boolAssert(predicate: Boolean) = {
  if (assertionEnabled && !predicate) {
    throw new AssertionError
  }
}

byNameAssert(5 > 3)
byNameAssert(!(2 > 3))

// Disable assertion
assertionEnabled = false

val x = 14
byNameAssert(x / 0 == 0)
// boolAssert(x / 0 == 0) // -> Exception
