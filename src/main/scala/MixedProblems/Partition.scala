package MixedProblems

object Partition {

  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    val (evenList, oddList) = list.partition(_ % 2 == 0)
    println(evenList)
    println(oddList)


  }

}
