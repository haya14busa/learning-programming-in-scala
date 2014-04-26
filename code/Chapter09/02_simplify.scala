def containsNeg(nums: List[Int]) = nums.exists(_ < 0)
def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)

println(containsNeg(List(0, 1, -1, -2)))
println(containsOdd(List(0, 1, -1, -2)))

