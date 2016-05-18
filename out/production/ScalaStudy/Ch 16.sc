val fruit = List("apples", "oranges", "pears")
val nums = List(1,2,3,4)
val diag3 = List(
  List(1,0,0),
  List(0,1,0),
  List(0,0,1)
) // lists are immutable
// empty list has type List[Nothing]
val empty = List() // lists are recursive, arrays flat
// list and arrays are homogeneous
// lists are covariant
// Child extends Parent then List[Child] is subtype of List[Parent]
List(1,2,3,4).isInstanceOf[List[Any]]

// null is subtype of every reference class
null.isInstanceOf[List[AnyRef]] //?
null.isInstanceOf[AnyRef]
// Nothing is subtype of every type
List[Nothing]().isInstanceOf[List[Any]]

val xs: List[String] = List() // List[Nothing]()

// Nil :: Cons


val fruit1 = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums1 = 1 :: 2 :: 3 :: Nil
val nums2 = 1::(2::(3::Nil))
val diag31 = (1::0::0::Nil)::(0::1::0::Nil)::(0::0::1::Nil)
val empty2 = Nil

Array(1,2,3,4).foldLeft(0)((x,y) => x + 1)




