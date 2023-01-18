package MixedProblems

object Array_List_Mutablity {
  def testArray(array: Array[Int]): Unit = {
    val temp = array(0)
    array(0) = array(array.size - 1)
    array(array.size - 1) = temp
  }

  def testList(list: List[Int]): Unit = {
    val temp = list(0)
    println(list.updated(0, list(list.size - 1)))
    println(list)
    //    list.updated(list.size - 1,temp) = temp
  }

  def main(args: Array[String]): Unit = {
    val array: Array[Int] = Array(1, 3, 5, 7, 2, 8, 9, 6)
    println(array.mkString(" "))
    testArray(array)
    println(array.mkString(" "))

    val list: List[Int] = List(1, 3, 5, 7, 2, 8, 9, 6)
    println(list)
    testList(list)
    println(list)
  }
}
