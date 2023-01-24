package BasicExercise

object P06 {

  def wordCount(string: String): Map[String, Int] = {

    val tokens = string.split(" ").toList
    val output = tokens.groupBy(x => x)
    var myMap = Map[String, Int]()
    output.foreach(x => myMap += (x._1 -> x._2.length))
    myMap
  }

  def main(args: Array[String]): Unit = {
    val string = "hello how are you hello are you mad"
    println(wordCount(string))
  }
}
