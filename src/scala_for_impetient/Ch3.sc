val nums = new Array[Int](10)
val a = new Array[String](10)
val s = Array("Hello", "World")
s(0) = "Goodbye"
s
val t = Array(1, "World") // tuple
import scala.collection.mutable.ArrayBuffer

val b = ArrayBuffer[Int]()
// is same as b = ArrayBuffer[Int]()
b += 1
b += (1,2,3,4)
b ++= Array(5,6) // use ++ to add
b.insert(2,6)
b.insert(2,7,8,9) // insert 7,8,9 from second position
b.remove(2,3)// remove 3 elements from second position

b
0 until (b.length, 2)

"Alice" -> 10 // is same as
("Alice", 10)
var scores1 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))
val scores2 = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
 scores1 apply "Alice"
scores1("Bob")
//scores1("C") NoSuchElementException
val bobsScore = scores1("Bob")
scores1.getOrElse("N", 0)
scores1.get("Bob")//returns Option(Int)
//scores1("Fred") = 7
scores1 += ("Fred" -> 7)
scores1 -= "Alice"

