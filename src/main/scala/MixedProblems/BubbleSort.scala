package MixedProblems

object BubbleSort {

  def swap(array: Array[Int], i: Int, j: Int): Array[Int] = {
    val temp = array(i)
    array.updated(i, array(j)).updated(j, temp)
  }

  def bubbleSort(array: Array[Int]): Array[Int] = {
    def inner(array: Array[Int], arrayLength: Int): Array[Int] = {
      if (arrayLength <= 1) array
      else {
        val newArray = (0 until arrayLength - 1).foldLeft(array) {
          (acc, i) => if (acc(i) > acc(i + 1)) swap(acc, i, i + 1) else acc
        }
        inner(newArray, arrayLength - 1)
      }
    }

    inner(array, array.length)
  }

  def main(args: Array[String]): Unit = {

    //  Normal Array
    val array: Array[Int] = Array(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
    println(array.mkString(" "))
    println(bubbleSort(array).mkString(" "))

    //  Empty Array
    println(bubbleSort(Array.empty[Int]).mkString(" "))
  }
}
