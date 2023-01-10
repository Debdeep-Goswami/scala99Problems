package MixedProblems

object InsertionSort {

  def insertionSort(array: Array[Int]): Array[Int] = {
    for (i <- 1 until array.size) {
      var j = i - 1
      var element = array(i)
      while (j >= 0 && array(j) > element) {
        array(j + 1) = array(j)
        j -= 1
      }
      array(j + 1) = element
    }
    array
  }

//  def insertionSortRecursive(array:Array[Int],)

  def main(args: Array[String]): Unit = {
    val array: Array[Int] = Array(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
    println(insertionSort(array).mkString(" "))
  }

}
