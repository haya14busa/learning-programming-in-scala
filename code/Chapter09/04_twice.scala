def twice(op: Double => Double, x: Double) = op(op(x))

println(twice(_ + 1, 5))
