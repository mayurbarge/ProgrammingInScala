// Currying
/*
currying technology

def add(x:Int, y:Int) = x + y
is a normal function

def add(x:Int) = (y:Int) => x + y
is a curried function.The return value is a function expression.

 def add(x:Int)(y:Int) = x + y
is syntactic sugar
 */
def withClose(closeAble: { def close(): Unit })
             (op: { def close(): Unit } => Unit) {
  try {
    // closeAble loaned
    op(closeAble)
  } finally {
    closeAble.close()
  }
}
class Connection {
  def close() = println("close Connection")
}
val conn: Connection = new Connection()
withClose(conn)(conn =>
  println("do something with Connection"))


// Option, Some and None
def getProperty(name: String): Option[String] = {
  val value = System.getProperty(name)
  if(value != null) Some(value) else None
}
val osName = getProperty("os.name")
osName.foreach(print _)
val empty = getProperty("XYZZ")
println(empty.getOrElse("None"))

// pattern matching
osName match {
  case Some(value) => println(value)
  case _ => println("none")
}

empty match {
  case Some(value) => println(value)
  case _ => println("none")
}

def fibonacci(in: Any): Int = in match {
  case 0 => 0
  case 1 => 1
  case n: Int => fibonacci(n-1) + fibonacci(n-2)
  case n: String => fibonacci(n.toInt)
  case _ => 0
}

fibonacci(0)
fibonacci(3)
fibonacci(7)

class Person(name: String, age: Int) {
  override def equals(other: Any) = other match {
      // check if passed object is person
    case passedObj: Person => name.equals(passedObj.name)
    case _ => false
  }

}

// extractors
import scala.util.matching.Regex

object Email {
  def unapply(str: String): Option[(String,String)] =
    new Regex("""(.*)@(.*)""")
      .unapplySeq(str).get match {
      case user :: domain :: Nil => Some(user, domain)
      case _ => None
    }
}

"user@domain.com" match {
  case Email(user, domain) => println(user + "@" + domain)
}
//memory pattern
import scala.collection.mutable.WeakHashMap

val cache = new WeakHashMap[Int, Int]
def memo(f: Int => Int) = (x: Int) => cache.getOrElseUpdate(x, f(x))

def fibonacci_(in: Int): Int = in match {
  case 0 => 0;
  case 1 => 1;
  case n: Int => fibonacci_(n - 1) + fibonacci_(n - 2)
}
val fibonacci: Int => Int = memo(fibonacci_)

val t1 = System.currentTimeMillis()
println(fibonacci(40))
println("it takes " + (System.currentTimeMillis() - t1) + "ms")

val t2 = System.currentTimeMillis()
println(fibonacci(40))
println("it takes " + (System.currentTimeMillis() - t2) + "ms")

//implicit conversion
import java.text.SimpleDateFormat

implicit def strToDate(str: String) =
  new SimpleDateFormat("yyyy-MM-dd").parse(str)

println("2013-01-01 unix time: " + "2013-01-01".getTime()/1000


