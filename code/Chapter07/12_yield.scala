val filesHere = (new java.io.File(".")).listFiles
def scalaFiles = {
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
  } yield file
}

println(scalaFiles)

scalaFiles.foreach(println)
