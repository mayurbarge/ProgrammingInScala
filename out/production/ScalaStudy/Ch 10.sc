abstract class Element {
  def contents: Array[String] // abstract method

  // parameterless methods
  //uniform access principle
  // client code should not be affected by decision to implement an attribute as a field or method

  def height: Int = contents.length
  def width: Int = if(height == 0) 0 else contents(0).length

  // empty-paren methods

}

class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
}

// scala.AnyRef is same as java.lang.Object

val obj = new ArrayElement(Array("abc"))
obj.isInstanceOf[scala.AnyRef]

// in scala fields and methods belong to same namespace, making it possible for field to override a parameterless method
class ArrayElement2(conts: Array[String]) extends Element {
  //field overrides method
  val contents: Array[String] = conts
  // in Java a field and method with same name can be defined
  // scala does not allow
}

//scala has only two namespaces
// values and types
// values namespace includes fields methods packages and singleton objects
// you can import fields or methods from singleton

// parametric field
// private protected or override can be applied
class ArrayElement3(val contents: Array[String]) extends Element
val l = List(0,1,2,3,4)
l.foldLeft[Int](0)((accumulator, e) => accumulator + e)

class Cat {
  val dangerous = false
}
class Tiger(override val dangerous: Boolean = true,
           private var age: Int
           ) extends Cat

// calling super constructor
class LineElement(s: String) extends ArrayElement(Array(s))
{
  //override modifier is required when overriding concrete members
  // optional in case of abstract methods
  override def width = s.length
  override def height = 1
}

class UniformElement(
                    ch: Char,
                    override val width: Int,
                    override val height: Int
                    )
extends Element {
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}

// inheritance suffers from fragile base class problem

// zip creates tuples (1, "a")..
Array(1,2,3) zip Array("a", "b") mkString
Array("A", "B", "C").mkString(".")
object X {
class Animal {}
object Animal {
  private class Cat(val dangerous: Boolean, name: String = "Cat") extends Animal {}
  private class Tiger(override val dangerous: Boolean = true)
    extends Cat(dangerous, "Tiger"){}

  def getCat: Animal = new Cat(true)
  def getTiger: Animal = new Tiger

}
}
val tigerObj = X.Animal.getTiger


