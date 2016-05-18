// value classes are both abstract and final
//Unit type has a single value ()
def f = {}
f
val a = if(false) 10 else null // has type Any
val b = if(true) "" else null // has type String
val c = if(true) 10 else throw new Exception // throw returns a value Nothing
// Nothing is subtype of everything
def isEqual(x: Int, y: Int) = x == y
isEqual(421, 421)
def isEqualAny(x: Any, y: Any) = x == y
isEqualAny(421, 421)
// eq is reference equality eq defined on AnyRef
def isRefEqual(x: AnyRef, y: AnyRef) = x eq y
isRefEqual("h", "h") // strings are immutable
val x = ()
println("hi")
().isInstanceOf[Any]
().isInstanceOf[Unit]
//().isInstanceOf[AnyRef]

null.isInstanceOf[Unit]
//(throw new Exception).isInstanceOf[Nothing]



