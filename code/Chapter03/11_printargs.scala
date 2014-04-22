def printArgImperative(args: Array[String]): Unit = {
  var i = 0
  while (i < args.length) {
    println(args(i))
    i += 1
  }
}

def printArgFunctional1(args: Array[String]): Unit = {
  for(arg <- args) {
    println(arg)
  }
}

def printArgFunctional2(args: Array[String]): Unit = {
  args.foreach(println)
}

def formatArgs(args: Array[String]) = args.mkString("\n")


// Example
val editors = Array("Vim", "Emacs", "Sublime")
printArgImperative(editors)
printArgFunctional1(editors)
printArgFunctional2(editors)
println(formatArgs(editors))

// Test
val res = formatArgs(Array("zero", "one", "two"))
assert(res == "zero\none\ntwo")
