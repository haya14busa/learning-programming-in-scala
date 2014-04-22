import scala.io.Source

/*
 * widthOfLength(s: String)
 * width of length of a line
 * length of line: 28
 * width of length of a line: 2
 */
def widthOfLength(s: String) = s.length.toString.length

if (args.length > 0) {
  // Use toList to reuse
  val lines = Source.fromFile(args(0)).getLines().toList

  // Find the Longest Line
  val longestLine = lines.reduceLeft(
    (a, b) => if (a.length > b.length) a else b
  )
  val maxWidth = widthOfLength(longestLine)

  // Print
  for(line <- lines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " |" + line)
  }
}
else
  Console.err.println("Please enter filename")
