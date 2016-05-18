class ChecksumAccumulator {
  private var sum = 0
  //default is public
  def add1(b:Byte):Unit = {
    //b = 1 method params are val
    sum += b
  }
  // define a procedure
  // procedures are only called for side effects
  // called procedure because method looks like a procedure definition
  def add2(b:Byte) {sum += b}
  def checksum():Int = ~(sum & 0xFF) + 1

}

def f1():Unit = "this String gets lost" // is same as
def f2() {"this String gets lost"}

def f3() = {"this String is returned"} // is different returns String

object ChecksumAccumulator {
  private val cache = Map[String, Int] ()
  def calculate(s:String):Int =
  if(cache.contains(s)) cache(s)
  else {
    val acc = new ChecksumAccumulator
    for(c <- s)
      acc.add1(c.toByte)
    val cs = acc.checksum()
   // cache += (s->cs)
    cs
  }
}