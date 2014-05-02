package bobsrockets {
  package navigation {
    // bobsrockets.navigation package
    class Navigator {
      val map = new StarMap
    }
    class StarMap

    class Ship {
      val nav = new navigation.Navigator
    }
    package tests {
      // bobsrockets.navigation.tests package
      class NavigatorSuite
    }
  }
  package fleet {
    class Fleet {
      def addShip() = {
        new Ship
      }
    }
  }
}
