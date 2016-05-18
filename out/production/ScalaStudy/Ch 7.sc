import java.io.File

// every expression returns value
// if results in values
if(1>2) "TWO LESS" else "ONE LESS"
// while and do-while returns in Unit
//assignment results in ()

//for generator
val filesHere = (new File(".")).listFiles
for(file <- filesHere)
   println(file)
//filters
for(i <- 1 to 10 if i%2 == 0) {
  print(i + " ")
}
// for expression returns a collection whose type is determined by for expressions <- clauses
for(i <- 1 to 10
    if i == 4;
      j <- 1 to i) println(j +" ")

// producint new collection
// 1 to 10 returns Vector
def allEvenValues =
for {
  i <- 1 to 10
  if i%2 == 0
} yield i

println(allEvenValues)

val oneToTen = Array(1,2,3,4,5,6,7,8,9,10)
def allEvens = for {
  i <- oneToTen
  if i%2 == 0
} yield i
allEvens

// exceptions
// try catch finally returns a value
try {
  throw new Exception
} catch {
  case ex: Exception =>
    println("Exception found")
} finally {
  println("Finally")
}

// explict value throws from finally will overrule any other values
def f(): Int = try {return 1} finally {return 2}
f
def g(): Int = try {1} finally {2}
g

// match
// any kind of constants can be used in match
val foodItem = "salt"
foodItem match {
  case salt => println("pepper")
  case chips => println("salsa")
  case _=> println("huh?")
}

// Break class
import scala.util.control.Breaks._
breakable {
  for(i <- 1 to 10000) {
    if( i == 2)
      break
  }
}

// defining variables inside scope
// ; is necessary
val a = 1;
{
  val a = 2
}
