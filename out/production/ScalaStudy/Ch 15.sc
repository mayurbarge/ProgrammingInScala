abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,
                 left: Expr, right: Expr) extends Expr
// case adds factory methods with the name of the class
Var("x") // no need for new Var("x")

// my implementation of factory
object X {

  class Expr2(val name: String) {
    //def Expr2 : Expr2 = new Expr2(name)
  }
  object Expr2 {
    def apply(name: String): Expr2 = new Expr2(name)
  }
}
X.Expr2("abc")
// all parameters of case class implicitly get val prefix
val v = Var("x")
Number(1.0)
0
1
"Mohit"
val op = BinOp("+", Number(1.0), v)
op.copy(operator = "-")
def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => println("case1 matched"); e // double negation
  case a@BinOp("+", e, Number(_)) => println("Second case"); a// add zero
  case BinOp("*", e, Number(1)) => println("Third case"); e// multiplyig by one
  case obj: Expr => println("Any expr matched.."); obj
  case _ => println("Default"); expr
}
simplifyTop(UnOp("-", UnOp("-", Number(2.0))))
simplifyTop(BinOp("+", Var("Plus"), Number(9)))
simplifyTop(Var("abc"))
def match1(expr: Expr) = expr match {
  case BinOp(op, left, right) =>
    println(expr + " is a binary op")
}
//match1(null)
// constant expressions
// matches iteslf, any literal
def describe(x: Any) = x match {
  case 5 => "five"
  case true => "truth"
  case "hello" => "hi"
  case Nil => "empty list"
  case _=> "something else"
}
describe(Nil)

// variable pattern matches any object
def variable(x: Any) = x match {
  case 0 => "Zero"
  case something => "Not zero" + something
}
variable(0)
variable(true)
import math.{E, Pi}
E match {
  case Pi => "strange math? Pi = " + Pi
  case _=> "OK"
}
// a simple name starting with a lowercase letter is taken as pattern variable,
// all other references are taken to be constants
val pi = math.Pi
E match {
  case pi => "strange math? " + pi
  case _=> "OK"

}

//constructor patterns
// sequence patterns
List(0, 1,3) match {
  case List(0, _, _) => "List matched"
}

// when no pattern matches MatchError is thrown
/*List(1) match {
  case List(0, _, _) => "List matched"
  // throws MatchError if nothing matches
}*/

List(0,1,2) match {
  case List(0, _*) => "List of variable length matched"
}
// Tuple patterns
(1,2,3) match {
  case (a,b,c) => println("matched: "  + a+ b+ c)
  case _ =>
}

// typed patterns
// s and x refer to same value but x is of type Any
// s is of type String
def generalSize(x: Any) = x match {
  case s: String => s.length
  case m: Map[_, _] => m.size
  case _=> -1
}
generalSize("abc")
generalSize(Map(1 -> "ONE"))

def generalSize1(x: Any) = x match {
  case s: String =>
      x.asInstanceOf[String]
  case _=> "None"
}
// returning x by converting it to string asInstanceOf
generalSize("A")
// type erasure
// no information about type arguments is maintained at runtime
// all generics like syntax are removed from code
def isIntIntMap(x: Any) = x match {
    // argument Int in pattern is erased at runtime
  case m: Map[Int, Int] => true
  case _=>  false
}
// due to type erasure both methods return true
isIntIntMap(Map(1->1))
isIntIntMap(Map("abc" -> "abc"))

// only exception is arrays
def isIntArray(x: Any) = x match {
  case a: Array[Int] => "yes"
  case _=> "no"
}
isIntArray(Array("abc"))
isIntArray(Array(1))

// variable binding or handlers

def getAbsolute(x: Expr) = x match {
  case UnOp("abs", e @UnOp("abs", _)) => println("abs matched.."); e
  case _=>
}
getAbsolute(UnOp("abs", UnOp("abs", Number(1.0))))

def sameObject(x: Expr) =  x match {
  case a@UnOp("same", UnOp("same", Number(1.0))) => a
  case _=>
}
sameObject(UnOp("same", UnOp("same", Number(1.0))))