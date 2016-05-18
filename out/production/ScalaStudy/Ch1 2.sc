var capital = Map("US"->"Washington", "France"->"Paris")
capital += ("Japan"->"Tokyo")
println(capital("France"))
var capital2=Map("A"->Unit)
val c = capital2("A")
//capital2 +=(null->null)
//println(capital2(null))

// function literals
// colorMe(f:{}) = {f} .. check what this is?
println("ColorMe")
// f: accepts nothing returns values of type Unit
def colorMe(f: () => Unit) = {
  f() // f() calls actual function passed
}
// () => ... passing annonymous function
colorMe{() =>println("With {}....")}
colorMe(()=>println("With ()...."))
println("ColorMe2")
def colorMe2(f: () => Unit) = {}
//colorMe2: colorMe2[](val f: () => Unit) => Unit
colorMe2{() =>println("With {}....")}
colorMe2(()=>println("With ()...."))
println("ColorMe3")
//colorMe3: colorMe3[](val f: () => Unit) => () => Unit
def colorMe3(f: () => Unit) = {
  f // returns function, hence you get <function0> at output
}
colorMe3{() =>println("With {}....")}
colorMe3(()=>println("With ()...."))
println("ColorMe4")
// colorMe4[](val f: AnyRef) => AnyRef
def colorMe4(f:{}) = {
  //f() why this does not work ?
  f // this works
}
colorMe4{() =>println("With {}....")}
colorMe4(()=>println("With ()...."))
println("ColorMe5")
// colorMe5[](val f: AnyRef) => Unit
def colorMe5(f:{}) = {}

def colorMe6(f:{def print}) = {
  f.print
}
def funX() = {def print="colorme6"}
val fvar4 = funX()
//colorMe6(fvar4)

// colorMeParam accepts a function such that
// it accepts String type and returns type C
// C is parameterized type
def colorMeParam[C](f:(String) => C) = {
  f
}

val thrill = "kill"::"bill"::"till"::Nil
// exists(p:(String)=>Boolean)
// parameter definition accepts method with String input and returning Boolean
// f=> f=="kill"s
// means a function accepting f as parameter and comparing it with "kill"
thrill.exists(f=>f=="kill")

// colorMeParam takes an annymous function
// with String param x and returns String
colorMeParam((x:String)=>"X")
def fun(x:String) = {
  x
}
val fvar = fun("ZZZ") // fvar is a value returned by fun
val fvar2 = (x:String) => x // fvar2 is a function variable, kind of a pointer to the definition
//colorMeParam(fun("ZZZ")) not working
colorMeParam(fvar2)




//
//val x = println("abc")

// function literal in scala
// (x: Int, y: Int) => x+y

// this is a method
def add(a: Int, b: Int) = { a + b }

// this is a function
// we can pass functions as parameters to other functions
// annonymous function
def addfunc = (x:Int,y:Int) => x+y
addfunc(1,2)

