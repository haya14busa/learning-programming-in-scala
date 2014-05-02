// bobsdelights/package.scala File
package object bobsdelights {
  def showFruits(fruit: Fruit) = {
    import fruit._
    println(name + "s are " + color)
  }
}

