// PrintMenu.scala File
package printmenu

import bobsdelights.Fruits
import bobsdelights.showFruits

object PrintMenu {
  def main(args: Array[String]) {
    for(fruit <- Fruits.menu) {
      showFruits(fruit)
    }
  }
}
