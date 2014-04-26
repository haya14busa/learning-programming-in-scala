import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

val file = new FileReader("input.txt")
try {
  // val f = new FileReader("input.txt")
} catch {
  case ex: FileNotFoundException => println("FileNotFoundException")
  case ex: IOException => println("IOException")
} finally {
  file.close
}

