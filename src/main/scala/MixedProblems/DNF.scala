package MixedProblems

import scala.annotation.tailrec

object DNF extends App {

  def solvDnf(array: Array[Int]): Array[Int] = {
    var low = 0
    var mid = 0
    var high = array.size - 1
    while (mid <= high) {
      if (array(mid) == 2) {
        //  Swap with high pointer
        val temp = array(high)
        array(high) = array(mid)
        array(mid) = temp
        high -= 1
        mid += 1
      }
      else if (array(mid) == 0) {
        //  Swap with low pointer
        val temp = array(low)
        array(low) = array(mid)
        array(mid) = temp
        low += 1
        mid += 1
      }
      else mid += 1
    }
    array
  }

  def solveDnfRecursive(array: Array[Int]): Array[Int] = {
    @tailrec
    def inner(array: Array[Int], low: Int, mid: Int, high: Int): Array[Int] = {
      if (mid > high) array
      else {
        if (array(mid) == 2) {
          //  Swap with high pointer
          val temp = array(mid)
          array(mid) = array(high)
          array(high) = temp
          inner(array, low, mid + 1, high - 1)
        }
        else if (array(mid) == 0) {
          //  Swap with low pointer
          val temp = array(mid)
          array(mid) = array(low)
          array(low) = temp
          inner(array, low + 1, mid + 1, high)
        }
        else inner(array, low, mid + 1, high)
      }
    }

    inner(array, 0, 0, array.size - 1)
  }

  val array: Array[Int] = Array(1, 2, 2, 1, 1, 0, 0, 2, 1, 1)

  println(solvDnf(array).mkString(" "))

  println(solveDnfRecursive(array).mkString(" "))

}
