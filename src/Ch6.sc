import scala.util.matching.Regex

class Rational(n: Int, d: Int) {
  println("Created " + n + "/" + d)
  println("Super class is " + super.getClass.getName)

  val numer: Int = n
  val denom: Int = d

  require (d != 0) // preconditions


  def this(n: Int) = this(n, 1) // auxillary constructor
  // in scala only primary constructor can invoke super constructor

  override def toString = n +"/"+ d
  def add(that: Rational): Rational =
    new Rational(n * that.denom + that.numer * d, d * that.denom)
}
val rational = new Rational(1,2)
val oneHalf = new Rational(1,2)
val twoThrids = new Rational(2, 3)
oneHalf add twoThrids


//val infinity = new Rational(3,0) throws illegal argument : requirement failed exception

val regex = new Regex("[H|C|D|S][2-9|T|J|Q|K|A]*")



