def sumInt(x:Int, f:(Int)=>Int) = f(x)
def squareInt(x:Int) = x*x
sumInt(2, squareInt)
sumInt(4, squareInt)

def sum[A, B](x:A, f:(A) => B) = f(x)
def square(x:Int) = x*x
sum(2, square)
sum(3.0, (x:Double) => x*x)

