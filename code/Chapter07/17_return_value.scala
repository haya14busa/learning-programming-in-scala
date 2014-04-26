import java.net.URL
import java.net.MalformedURLException

def urlFor(path: String) = {
  try {
    new URL(path)
  } catch {
    case e: MalformedURLException =>
      new URL("http://www.scala-lang.org")
  }
}

println(urlFor("http://www.google.com"))
assert(urlFor("ttp://www.google.com") == new URL("http://www.scala-lang.org"))
