def approximate(guess: Double): Double = {
  if (isGoodEnough(guess)) guess
  else approximate(improve(guess))
}
