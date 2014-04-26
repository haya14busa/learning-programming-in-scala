def gcd(x: Long, y: Long): Long = {
  if (y == 0) x else gcd(y, x % y)
}

assert(gcd(15, 3) == 3)
assert(gcd(3, 18) == 3)
