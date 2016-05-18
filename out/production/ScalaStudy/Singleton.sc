
object Temp {

  class Main {
    private val foo: String = "Foo"

    private def printWorld = print(" World ! \n")

    def printBar = {
      Main.bar
    }
  }

  // class and companion should be defined in same file
  // class and companion objects can access each others private members

  object Main {
    // companion object can access private variables of Class
    private val bar: String = "Bar"

    def printHelloWorld = {
      print("Hello ")
      val obj = new Main
      obj.printWorld
    }
    def printFoo = {
      val obj = new Main
      obj.foo
    }
  }

}

// companion class
// class Main is the companion class of object Main
//companion object
// object Main is the companion object of class Main
Temp.Main.printFoo
Temp.Main.printHelloWorld
val obj:Temp.Main = new Temp.Main
obj.printBar
def obj2:Temp.Main = new Temp.Main
obj2.printBar

// type is defined by the singleton object's companion class
// type Main is defined by class Main

/*
It's not your failure, it's the interpreter's. Because it reads in things one at a time, it has trouble associating things like a class and its companion object. Try wrapping them in another object so the interpreter compiles them together:
 */

//each singleton object is implemented as instance of synthetic class
//standalone object is one that does not share same name as companion class
Predef.println("ABC")


object Main {

  def main(args: Array[String]): Unit = {
    Predef.println("Hello World ~~")
  }
}
