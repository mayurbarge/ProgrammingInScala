val formatter = java.text.NumberFormat.getIntegerInstance

formatter.format(10000)

import java.util.regex.Pattern
val x = Pattern.quote("2-[1-Isopropylamino-Methylidene]-Cyclohexanone")
val compiled = Pattern.compile(x)
"2-[1-Isopropylamino-Methylidene]-Cyclohexanone lineshape".replaceAll(compiled.toString, "")


val words: Array[String] = "tin zinc sulfate ff g g".split(" ")
words.sliding(2).map(
  x => {
  //println(x.toList , x.mkString(" "))
  x.mkString(" ")

  }).toList