/*
Rationals behind the use of Companion objects
Here are a few reasons, which might be more or less compelling for you,
depending on your own preferences:

Do not simply discount it for being "syntactic sugar"
 While you may say that something is just syntactic sugar,
  it is after all the sugar that sweetens your life -
  as a programmer just as well as a coffee or tea drinker.

Singletons - every Scala object is inherently a singleton.
 Considering that in the Java world people are implementing singletons
 in all sorts of different ways and more often than not end up
  making some mistake in their implementation, you cannot make an
  error as simple like that in Scala. Writing object instead of class
  makes it a singleton and you're done.

Access to static methods: The static methods in Java can be accessed from objects
 For example, suppose you have a class C with a static method f and an object c of
 type C. Then you should call C.f, but Java allows you (albeit with a warning)
 to use c.f, which when you come from the Scala background doesn't really make any
 sense, because objects do not have a method f really.

Clear separation: In Java you can mix static and non-static attributes and methods
in a class. If you work disciplined, this doesn't become a problem, however,
 if you (or someone else for that matter) do not,
 then you end up with static and non-static parts interleaved and
 it is hard to tell at a quick glance what's static and what's not. In Scala,
 everything that's located inside the companion object is cleary not part of the
 corresponding class's runtime objects, but is available from a static context.
 Vice versa, if it is written inside a class, it is available to instances of that
 class, but not from a static context. This becomes especially burdensome in Java,
 once you start adding static and non-static initializer blocks to your class.
 This can end up to be very hard to comprehend in terms of dynamic execution order
  It's a lot clearer in Scala, where you initialize the companion object from top to
   bottom and then do the same for the class in case of a runtime object being created.


Less code: You don't need to add the word static to each and every attribute or
 method in an object, thus keeping the code more concise
 (indeed, not a prominent advantage really).


 */
object blah {
  def sum(l:Array[Int]): Int = l.sum
}

blah.sum(Array(1,2,3,4))

//blah.sum(Array(1.1,1.1,1.1,1.1))

class InitPair(val x: Int, val y: Int)
object InitPair {
  import math.Ordering
  implicit def ipord: Ordering[InitPair] =
    Ordering.by(ip => (ip.x, ip.y))
}

Math.sqrt(4)
Math.p
