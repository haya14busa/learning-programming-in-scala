import scala.util.control.Breaks._
import java.io._

val in = new BufferedReader(new InputStreamReader(System.in))

breakable {
  while (true) {
    print(">>> ")
    if (in.readLine() == "") break
  }
}
