def plainOldSum(x: Int, y: Int) = x + y

println(plainOldSum(1, 2))

def curriedSum(x: Int)(y: Int) = x + y
println(curriedSum(1)(2))

def first(x: Int) = (y: Int) => x + y
val second = first(1)
println(second(2))
