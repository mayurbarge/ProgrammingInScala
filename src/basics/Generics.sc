/*
Try to change

"123456"
to

123456
Although the type of msg changed from String to Int, the program still compiles.
 */

def withClose[A <: { def close(): Unit }, B](closeAble: A)
                                            (f: A => B): B =
  try {
    f(closeAble)
  } finally {
    closeAble.close()
  }
class Connection {
  def close() = println("close Connection")
}
val conn: Connection = new Connection()
val msg = withClose(conn) { conn =>
{
  println("do something with Connection")
  "123456"
}
}

println(msg)

