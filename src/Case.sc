case class Person(age:Int, name: String)
val list = List(Person(27, "mayur"), Person(14, "Ki"), Person(45, "Jira"))
list.sortBy((f) => f.age)
list.sortBy(_.age)
list.sortBy(-_.age)

list.sortBy((f) => f.name)
list.sortBy((f) => -f.age)



