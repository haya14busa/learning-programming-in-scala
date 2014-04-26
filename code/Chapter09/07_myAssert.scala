// Without by-name parameter
var assertionEnabled = true
def myAssert(predicate: () => Boolean) = {
  if (assertionEnabled && !predicate())
    throw new AssertionError
}
