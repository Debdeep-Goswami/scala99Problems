package MixedProblems

object StrictlyIncreasingArray {

  def isStrictlyIncreasing(array: Array[Int]): Boolean = {
    def inner(array: Array[Int], index: Int): Boolean = {
      if (index == array.size - 1) true
      else if (array(index) < array(index + 1)) inner(array, index + 1)
      else false
    }

    inner(array, 0)
  }

  def main(args: Array[String]): Unit = {

    val array:Array[Int] = Array(1,2,3,2,4,5,6)
    println(isStrictlyIncreasing(array))

  }

}
