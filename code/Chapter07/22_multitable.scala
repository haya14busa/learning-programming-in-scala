def printMultiTable() = {
  var i = 1
  // i
  while (i <= 10) {
    var j = 1
    // i, j
    while (j <= 10) {
      val prod = (i * j).toString // product
      // i, j, prod
      var k = prod.length
      // i, j, prod, k
      while (k < 4) {
        print(" ")
        k += 1
      }
      print(prod)
      j += 1
    }
    // i, j
    println()
    i += 1
  }
  // i
}

printMultiTable()
