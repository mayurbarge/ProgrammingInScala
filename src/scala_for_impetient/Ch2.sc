/*
In scala all constructs have values
 */
// void type is Unit
val x = 0
val c1 = if(x > 0) 1 else -1
// type of mixed-ty[e expression is the common supertype of both branches
val c2 = if(x > 0) "positive" else -1
if(x > 0) 1; if(x>0) 1 else ();
var y = 0
if( y > 0) 1
// multiline - line ends in symbol which cannot be the end of statement
val c3 = 8 +
8
// assignments have value Unit
// Unit type has a single value ()
val t = {val c4 = "str"}
val x1 = y = 1 // x1 is Unit
//readLine, readInt, readDouble
//val name = readLine("Your name: ")
//print("Your age: ")
//val age = readInt()
//printf("Hello, %s ! Your age + 1 is %d ", name, age +1)
def add(x: Int, y: Int) = x+y
def add5(x:Int) = x+5
def add3(y:Int) = y + 3
def addCurry(x:Int)(y:Int)=x+y
val temp = addCurry(3)(2)

// factorial with scala BigInt
def factorial(x:BigInt) : BigInt = {
  if (x < 2) return 1 else x * factorial(x-1)
}
println(factorial(30))
//factorial with Java BigInteger
import java.math.BigInteger

import scala.collection.immutable.HashMap

def factorialJava(x: BigInteger) : BigInteger = {
  if(x == BigInteger.ZERO) return BigInteger.ONE
  else
    x.multiply(factorialJava(x.subtract(BigInteger.ONE)))
}
println(factorialJava(new BigInteger("30")))
// function value is an Object
def print = println("Hello")
print
//function types are classes
print.getClass
def printPrint(p: {def print}) = {}
//every value is object, every operation is method call
class MyClass (name: String)
val obj:MyClass = new MyClass("MyClassString")
println(obj)

//
val nameHasUpperCase = "abCde".exists(_.isUpper)


// Define predicate
def isNumber(ch: Char) = {
  ch.isDigit
}

val map = new HashMap[Int, String]()
val map2:Map[Int, String] = new HashMap()

// type inference
//variable: Type syntax lets you omit the type which can not be done with Type variable syntax
val v1=8
val v2:Int = 8
//type annotation must follow every function parameter
// scala compiler does not infer function parameter types
//def max(x,y:Int) wont work

//recursive functions need result type
def factorial(x:Int):Int = {
  if(x == 1) 1 else x + factorial(x-1)
}
factorial(5)

def decorate(str:String, left:String="[", right:String = "]")=
left+str+right
decorate("mayur")
decorate("mayur","{","}")
//variable number of arguments
def sum(args:Int*) = {
  var result = 0
  for(arg <- args) result += arg
  result
}
sum(1,2,3)
//val s = sum(1 to 5) error
val s = sum(1 to 5: _*)


// procedures: function which do not return value
//used only for side effects
def box(s:String): Unit = {
  val border = "_"* s.length + "__\n"
  println(border + "|" + s + "|\n" + border)
}
box("box")

def box2(s:String) {
  // no =
}

def ff() = "rds"
lazy val words = "wo" + ff()


//assignments

def signum(x:Int) = {
  if(x < 0) -1
  else if(x > 0) 1
  else 0
}

signum(0)
signum(-2)
signum(2)

{} // is Unit
var yy : Int
var xx: Unit
xx = yy = 1
//for(int i=10;i>=0;i--) Sysout(i)
for( i<- 1 to 3;j<-1 to 3;) printf("%d", i)

