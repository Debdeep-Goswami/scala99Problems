package BasicExercise

object P11 {

  def concat(list1: List[Int], list2: List[Int]): List[Int] = {
    list2.foldLeft(list1)((acc, cur) => acc :+ cur)
  }

  def main(args: Array[String]): Unit = {
    val list1: List[Int] = List(1, 2, 3, 4)
    val list2: List[Int] = List(5, 6)

    println(concat(list1, list2))
  }

}
