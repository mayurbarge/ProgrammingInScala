import java.math.BigInteger

// ?
//var map = Map(Init->String)
//map+=(1->"jj" +  ""+ "")
//println(map(1))


// parameterize object with values
val big = new BigInteger("1234")
//parameterize object with type
val greetStrings = new Array[String](3)
// or val greetStrings:Array[String] = new Array[String](3)
greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "World!\n"
for(i<- 0 to 2) print(greetStrings(i))


// when method takes one param you can ignore dot and parentheses
println("OneParam") // is similar to
Console println "OneParam"
// only wroks if you explicitly specify receiver of method call

// Why array access with parentheses
// because array access is a method call in scala
greetStrings(0) // is similar to
greetStrings.apply(0) //is similar to
greetStrings apply 0
// any object with parentheses call is transformed into call to apply method
greetStrings(0) = "abc" // is similar to
greetStrings.update(0, "abc") // is similar to

// calls apply methos on Array companion object
val numNames = Array("zero","one") // is similar to
Array.apply("zero","one")
// scala lists are immutable and arrays are mutable
val oneTwo = List(1,2)
val threeFour = List(3,4)
val oneTwoThreeFour = oneTwo:::threeFour
val zeroOneDotDot = 0 :: oneTwoThreeFour
//method names with :: use right operand
val zeroOneTwo = oneTwo.::(0)
//normal method execute on left operand
val l1 = 1 to 3
val l2 = 1.to(3)
//Nil is List()
val abc1 = "a"::"b"::"c"::Nil
val abc2 = Nil.::("a").::("b").::("c")
var thrill = "Will"::"fill"::"until"::Nil
thrill.count(f=>f.length==4)
thrill.drop(2)
thrill.dropRight(2)
//exists(p:(String)=>Boolean)
thrill.exists(f=>f=="until")
//foreach[U](f:(String)=>U)
thrill.foreach(s=>print(s)) // is same as
thrill.foreach(print)
// add "y" to each element
thrill.map(s=>s+"y")
thrill.mkString(",")
thrill.sortWith((s,t)=>s.charAt(0).toLower
  < t.charAt(0).toLower)

//tuples can contain different types of objects
val pair = (99, "Luftballons")
println(pair._1)  //pair has type Tuple2[Int,String]
println(pair._2)
// mutable and immutable sets
var jetSets = Set("Boeing", "Airbus")
jetSets += "Lear"
println(jetSets.contains("Cessena"))
import scala.collection.mutable.Set
val movieSet = Set("Hitch", "Poltergeist")
movieSet += "Shrek"
// jetSets with val declaration does not allow to us to add new element
// here movieSet even declared with val allows updates
import scala.collection.mutable.Map
val treasureMap = Map[Int, String]()
treasureMap += (1->"Go to island.")
treasureMap += (2->"Find big X on ground.")
treasureMap += (3->"Dig.")
println(treasureMap(2))
treasureMap.+=(4->null) // allows null values
println(treasureMap(4))
//treasureMap.+=(null->null) fails
//treasureMap += (Unit -> Unit) fails
//treasureMap += (5->Unit) fails
1 -> "Go to island." // returns tuple
// calling -> on any object returns tuple
"one".->("Go to island.")





import scala.io.Source
val filePath = System.getProperty("user.home") +
"/Documents/test/hello.scala"
for(line <- Source.fromFile(filePath).getLines()) {
  println(line.length + " " + line)
}


