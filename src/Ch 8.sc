def fun = {
  def funInner = {
    println("Inner")
  }
  print("Outer")
  funInner
}
fun
//function literals exists in code, function values exists at runtime
// literal is compiled into a class
(x: Int) => x+ 1
//
var increase = (x: Int) => x + 1
increase(10)
increase = (x: Int) => x + 9999
increase(10)
// each function value is an instance of FunctionN trait
// this trait has apply method used to invoke function

// short forms of function literals
// filter accepts f: (Int) => Boolean
// target typing
List(1,2,3,4).filter((x) => x %2 == 0)
List(1,2,3,4).filter(x => x == 1)
List(1,2,3,4).filter(_ == 2) // _ refers to values of list
// _ is seen as a blank that is filled in by values of collection
List(("ONE", 1), ("TWO", 2)).filter(_._1 == "ONE")

// you can use this form only if each parameter appears in function only once
// _ in left hand and _ in right hand are different parameters
val f = (_: Int) + (_: Int)
f(1,2)
// partially applied function
def sum(a: Int, b: Int, c: Int) = a + b + c
sum(1, 2, 3)
// reulst is a: (Int, Int, Int) => Int = <function3>
val a = sum _
a(1,1,1)
// partially applied function
val b = sum(1, _:Int, 3)
b(1)
Array(1,2,3).foreach(b)

// closures
var more = 1
val addMore = (x: Int) => x + more
addMore(10)
// x + 1 is closed term x + more is open term
// x is bound, more is free variable
// x + more is called closure
// because function value is the end product of closing the open term
more = 999
addMore(10) //closure sees the change

//changes made by closure to captured variables are visible outside the closure
val someNumbers = List(-11, -10, -5, 0, 5, 10)
var sum2 = 0
someNumbers.foreach(sum2 += _)
sum2

//

more = 1
def makeIncreaser(more: Int) = (x:Int) => x + more
val inc1 = makeIncreaser(1)
val inc9999 = makeIncreaser(9999)
inc1(10)
inc1(10)
val inc20 = makeIncreaser(20)
inc20(1)

// varargs
// String* is Array[String]
def echo(args: String*) =
for (arg <- args) println(arg)
echo("hello", "world!")


val arr = Array("What's", "up", "m")
echo(arr: _*)
// _* tells compiler to pass each element or arr as its
// own argument to echo, rather than all of it as a single arg

// named parameters
def speed(distance: Float, time: Float): Float = distance/time
speed(time=10, distance = 100)



