// define class
class Person(val firstName: String, val lastName: String) {

  private var _age = 0
  def age = _age
  def age_=(newAge: Int) = _age = newAge

  def fullName() = firstName + " " + lastName

  override def toString() = fullName()
}
val obama: Person = new Person("Barack", "Obama")
println("Person: " + obama)
println("firstName: " + obama.firstName)
println("lastName: " + obama.lastName)
obama.age_=(51)
println("age: " + obama.age)
// define class
class Employee(private val empId:Int, val empName: String) {
  private var _salary = 0.0
  def salary = _salary
  def getId() = empId
 // def salary_ = (newSalary: Float) = _salary = newSalary
}
val e:Employee = new Employee(1, "EmployeeA")

println("Employee get id: " + e.getId())
println(e.empName)


// duck typing
/*

  closeAble: <Param Type>
  op: <Param Type> => <Return Type>


  op function has parameter which accepts
  any method with def close() method defined

  With normal typing, suitability is assumed to be determined by a
  object's type only. In duck typing, an object's suitability is
  determined by the presence of certain methods and properties
  (with appropriate meaning), rather than the actual type of the
  object

*/

def withClose(closeAble: { def close(): Unit },
              op: { def close(): Unit } => Unit) {
  try {
    op(closeAble)
  } finally {
    closeAble.close()
  }
}

class Connection {
  def close() = println("close Connection")
}

val conn: Connection = new Connection()
withClose(conn, conn =>
  println("do something with Connection"))



