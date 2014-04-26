val filesHere = (new java.io.File(".")).listFiles
def fileLines(file: java.io.File) = {
  scala.io.Source.fromFile(file).getLines().toList
}

def grep(pattern: String) = {
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLines(file)
    trimmed = line.trim // bind variable
    if trimmed.matches(pattern)
  } {
    println(file + ": " + trimmed)
  }
}

grep(".*gcd.*")
