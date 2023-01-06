package BasicExercise

import scala.annotation.tailrec

object P04 {

  /*
  def fill(element:Int )(noOfTimes:Int):List[Int]={ }
  Example:
  fill(3)(4)
  => List(3,3,3,3)
   */
  def fill(element: Int, times: Int): List[Int] = {
    @tailrec
    def inner(ans: List[Int], element: Int, times: Int): List[Int] = {
      if (times == 0) ans
      else inner(element :: ans, element, times - 1)
    }

    inner(List.empty[Int], element, times)
  }

  def main(args:Array[String]) : Unit  = {
    println(fill(3, 4))
  }

}
