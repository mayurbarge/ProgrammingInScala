

val l1 = List("S1P1", "S1P2")
val substances = List("S1")
val properties = List("P1")

"S1P1".substring(0,2)
"S1P1".substring(2,"S1P1".length)




def wightF(substances: List[String], properties: String[String],
           list: List[String]): Double = {
  var currentWeight = 1000.0

  val C1 = 1000
  val C2 = 500
  val DEF_WEIGHT = 0.0

  val weight = 0.001



  list.map(
    string =>
      if(substances.contains(string.substring(0,2))
        && properties.contains(string.substring(2,string.length)) ) {
        currentWeight = currentWeight - weight
      } else if(substances.contains(string.substring(0,2))) {
        currentWeight = currentWeight - weight
      } else if(substances.contains(string.substring(2, string.length))) {
        currentWeight = C2 - weight
      }
  )
  weight
}

wightF()