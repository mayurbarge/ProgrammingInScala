// methods run on objects, functions do not
(x:Int)=>x+1
//is similar to
new Function1[Int, Int] {
  def apply(x:Int):Int = x+1
}
//apply function to a val
val fun = (x:Int,y:Int)=>x+y
fun(2,2)
val funNoParam = ()=>{System.getProperty("user.dir")}
funNoParam()

// annonymous function types
def function1(f:Int => Int); // is same as
def function11(f:Function1[Int,Int]);
def function2(f:(Int,Int)=>String) // is same as
def function22(f:Function2[Int,Int,String])
def function3(f:()=>String) // is same as
def function33(f:Function0[String])
