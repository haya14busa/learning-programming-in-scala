val filesHere = (new java.io.File(".")).listFiles
def fileLines(file: java.io.File) = {
  scala.io.Source.fromFile(file).getLines().toList
}
def grep(pattern: String) = {
  for {
    file <- filesHere
    if file.getName.endsWith(".scala") // require semicolon, othrewise use {}
    line <- fileLines(file)
    if line.trim.matches(pattern)
      } {
    println(file + ": " + line.trim)
  }
}

grep(".*gcd.*")
