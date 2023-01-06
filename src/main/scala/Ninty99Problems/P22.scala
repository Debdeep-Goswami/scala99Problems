package Ninty99Problems

import scala.annotation.tailrec

object P22 extends App {

  //  Problem Statement
  //  P22 (*) Create a list containing all integers within a given range.

  //  Solution 1 With built in function
  def displayList(start: Int, end: Int): List[Int] = {
    List.range(start, end + 1)
  }

  //  Solution 2 with tail recursion
  def displayList2(start: Int, end: Int): List[Int] = {
    @tailrec
    def inner(start: Int, end: Int, list: List[Int]): List[Int] = {
      if (start > end) list
      else inner(start + 1, end, list :+ start)
    }

    inner(start, end, List.empty[Int])
  }

  println(displayList(5, 10))
  println(displayList2(5, 10))

}
