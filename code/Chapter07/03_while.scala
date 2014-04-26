def gcdLoop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a = b % a
    b = temp
  }
  return b
}

assert(gcdLoop(15, 5) == 5)
assert(gcdLoop(42, 49) == 7)
