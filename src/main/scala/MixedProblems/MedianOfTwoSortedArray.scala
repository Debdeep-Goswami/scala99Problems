package MixedProblems

object MedianOfTwoSortedArray extends App {

  def findMedianOfTwoSortedArray(array1: Array[Int], array2: Array[Int]): Double = {

    def findMedian(mid: Int, isEven: Boolean): Double = {
      def inner(mid: Int, count: Int, isEven: Boolean, lastElement: Int, array: Array[Int], array1: Array[Int], array2: Array[Int]): Double = {
        if (mid == count & isEven == false) {
          lastElement
        } else if (mid - 1 == count && isEven == true) {
          (lastElement + array.head) / 2.0
        }
        else {
          if (array1.isEmpty) inner(mid, count + 1, isEven, array2.head, array2.tail, array1, array2.tail)
          else if (array2.isEmpty) inner(mid, count + 1, isEven, array1.head, array1.tail, array1.tail, array2)
          else if (array1.head < array2.head) inner(mid, count + 1, isEven, array1.head, if(array1.tail.isEmpty) array2 else array1.tail, array1.tail, array2)
          else inner(mid, count + 1, isEven, array2.head, if (array2.tail.isEmpty) array1 else array2.tail, array1, array2.tail)
        }
      }

      inner(mid, -1, isEven, -99, Array.empty[Int], array1, array2)
    }

    val totalLength = array1.size + array2.size
    val median = if (totalLength % 2 != 0) findMedian(totalLength / 2, false) else findMedian(totalLength / 2, true)
    median
  }

  val a1: Array[Int] = Array(1,7,8,10)
  val a2: Array[Int] = Array(2,4)
  println(findMedianOfTwoSortedArray(a1, a2))
}
