def half(n: Int): Int = {
  if (n % 2 == 0) {
    n / 2
  } else {
    throw new RuntimeException("n must be even")
  }
}

println(half(4))
println(half(5))
