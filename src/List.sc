import scala.actors.A

//T{
//  def map[A,B] (f:A => B): T[B]
//
//  def flatMap[A,B](f:T[A] => B) : B
//}
//
//def map(f:Int => Int) :List[Int]
//
//def f(x:Int): Int = x * x
val a  = List(1,2,3)

//val  b = List(List(1,2),List(3,4),List(5,6))
//
//def f(lis:List[Int]) = lis


//def flatMap(f:Int => List[Int] ):List[Int]

a.map(x=>x*2)

def stringToList(s:String): List[String] = s.split(",").toList


List("a,b").flatMap(stringToList(_))
List("a,b").map(stringToList(_))

//map followed by flatten


val l =  List(1,2,3,4,5)
l.map(x=> x*2)
//convert List[Int] to List[Option[Int]]
l.map(x=> if(x>3) Some(x) else None)
// flatMap works applying a function that returns a sequence for each element in the list, and flattening the results into the original list

def g(x: Int) = List(x-1, x, x+1)

l.map(g)
l.flatMap(g)

//own map function
def myMap(list: List[Int], f:Int => Double): List[Double] = {
  list match {
    case (h: Int) :: (rest:List[Int]) =>
      List(f(h)) ::: myMap(rest, f)
    case Nil => List[Double]()
  }
}


val v = List(1,2,3,4)
def mapF (x:Int): Double = {x+10.5}
myMap(v, mapF)


// List(X,X,X,Y,X,X)
// need output((X,3), (Y,1), (X,2))

def myFoldLeft(list: List[String]): List[(String, Int)] = {

  list.foldLeft(Nil : List[(String, Int)])((acc, e) =>
      acc.headOption match {
        case Some(x) if(x._1 == e) => (e, x._2+1) :: acc.tail
        case Some(y:(String, Int)) => y :: acc
        case None => List((e, 1))
      }
  ).reverse
}

case class MyList[T](elements:T)
def map[A,B](f:(A)=>B)(myList: MyList[A]):MyList[B] = {
  MyList(f(myList.elements))
}

val intMyList = MyList(1)
val intToStringMapping = (a:Int)=> s"""--- $a ---"""
val mapped = map(intToStringMapping)(intMyList)


