package MixedProblems

object MissingPositive {

  val nums1: Array[Int] = Array(1, 2, 0)
  val nums2: Array[Int] = Array(3, 4, -1, 1)
  val nums3: Array[Int] = Array(7, 8, 9, 11, 1, 12, 2)
  val nums4: Array[Int] = Array(1000, 2, 3, 1, 4, 5, 6, 9, 10, 13, 12, 17)
  val nums5: Array[Int] = Array(0, 1, 2)

  def findMissingPositiveLoop(array: Array[Int]): Int = {
    val n = array.length
    var i = 0
    while (i < n) {
      if (array(i) >= 1 && array(i) <= n && array(array(i) - 1) != array(i)) {
        val temp = array(array(i) - 1)
        array(array(i) - 1) = array(i)
        array(i) = temp
      }
      else i += 1
    }
    findResult(array)
  }

  def findMissingPositiveRecursive(array: Array[Int]): Int = {
    def inner(i: Int): Unit = {
      if (i < array.length) {
        if (array(i) >= 1 && array(i) <= array.length && array(array(i) - 1) != array(i)) {
          val temp = array(array(i) - 1)
          array(array(i) - 1) = array(i)
          array(i) = temp
          inner(i)
        }
        else inner(i + 1)
      }
    }

    inner(0)
    findResult(array)
  }

  def findResult(array: Array[Int]): Int = {
    def inner(array: Array[Int], i: Int): Int = {
      if (array(i) != i + 1) i + 1
      else if (i == array.length) array.length + 1
      else inner(array, i + 1)
    }

    inner(array, 0)
  }

  def main(args: Array[String]): Unit = {
    println(findMissingPositiveLoop(nums1))
    println(findMissingPositiveRecursive(nums1))
  }
}
