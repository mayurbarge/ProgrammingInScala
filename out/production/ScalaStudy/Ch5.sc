import com.sun.xml.internal.bind.AnyTypeAdapter

//Byte,Short,Int,Long,Char integral types
//including Float, Double numeric types
//scala value types
//Integer literals
9L
3
0xFF
//0xFFFFFFFFFFFFFF out of range
0xFFFFFFFF
Int.MaxValue
Int.MaxValue
Char.MaxValue
Char.MinValue
Long.MaxValue
Long.MinValue
Byte.MaxValue
Byte.MinValue
77777
val hex = 0x5
val magic = 0xcafebabe
//octal begins wih 0
//literal ending with L or l is long
val prog = 0XCAFEL


// float literals
0.0
1e30f
3.13f
  .1
// multiline
// three or more quotes
"""
    This is a multiline string
    literal, quotes
  |
""".stripMargin// strips leading whitespace
// xml literal
val b = <book><title>ABC</title></book>
println(
  """Welcome to Crest
      Type "HELP" for help.
  """.stripMargin)
println(
  """
    |Welcome to crest
    |Type "HELP" for help.
  """.stripMargin)

//symbol literals
scala.Symbol("x")
'ident
val s = 'aSymbol
s.name

//operators
val sum = 1 + 2
val sumMore = (1).+(2)
val longSum = 1 + 2L
// you can use any method in operator notation
val str = "Hello, world"
str indexOf 'o'
str indexOf ('o', 5)
//prefix notation
1 + 2
//prefix notation
// methods with unary_ preprended to the operator char
// + - ! ~ are only prefix operators
-7
-2.0 // is same as
(2.0).unary_-
// even if you define own infix method like p.unary_*
// you could not be able to use it with *p as only +-!~ is allowed

~0xFF // negation
//in prefix notation operand is to the right
//postfix notation
// in postfix notation operand is to the left
// postfix operators are methods that take no arguments
7 toLong

// use () if method has side effects
//1 user when method has side effects
"AB".toLowerCase // no side effects
"AB" toLowerCase
def toStr() = {
//toStr[]() => Unit
}
//2 Use when method does not change any state
def toStr2 = {} //toStr2[]() => Unit
//3 toStr3[]() => Unit
def toStr3() {return ""} // does not return anything
//4 to[] => Unit
//def to {} gives error only classes can have declared but undefined members
//def to2
// 1234 are all same, just dont use 34 as its not good practice of coding

'b' - 'a'
!false
// || && are short circuit operators
// as all operators are mehtods scala can skip execution of second part
// with delaying evaluation of arguments using by-name parameters
//bitwiese operators
1&2
1|2
1^3
~1
//equality
1 == 2
1 != 2
2 == 2

List(1,2,3) == List (1,2,3)
 1 == 1.0

List(1,2,3) == "Hello"
null == null
// first check left side for null, if it is not null, call equals method
("he" + "llo") == "hello"
// Java uses reference equality, in scala use eq or ne for reference checks
"Reference equality"
"hello" eq "abc"
"hello" eq "hello"
//precedence based on first char used
2 + 2 * 7
1&0|1
// */%  +-  :  =!  <>  &^|

// scala decides precedence based on first char of the method
// exceptions are mehods ending in = and methods not comparios operators (<= >= != ==)
// precedence of such methods is same as =
var x: Int = 2
var y: Int = 5
x *= y + 1 // * has high precedence than +
// same as x *= (y+1)
// but method ends in = so it will have same precedence as =
println(x)

// multiple operatos of same precedence >> associativity is determined by last char
// any method ending in : is invoked on its right operand passing left operand
// methods that end in any other char are other way aroundxa * b //
x * y // x.*(y) -- * method invoked on left operand
object X {
  def ::(x:Int) = {
    println("X::" + x);
  }
}
10::X // X.::(10) -- :: methos invoked on right operand
X.::(10)
// a:::b:::c is a:::(b:::c)
// a*b*c is (a*b)*c

0 max 5
1.5 isInfinity
