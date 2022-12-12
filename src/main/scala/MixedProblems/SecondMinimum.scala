package MixedProblems

import scala.annotation.tailrec

object SecondMinimum extends App {
  def findSecondMinimum(list: List[Int]): Option[Int] = {
    @tailrec
    def inner(min: Int, secondMin: Int, list: List[Int]): Option[Int] = {
      if (list.isEmpty) Some(secondMin)
      else if (list.head < min) inner(list.head, min, list.tail)
      else if (list.head < secondMin) inner(min, list.head, list.tail)
      else inner(min, secondMin, list.tail)
    }

    if (list.size < 2) None
    else inner(Integer.MAX_VALUE, Integer.MAX_VALUE, list)
  }

  //  Proper Input
  val list: List[Int] = List(1, 4, 2, 6, 8, 5, 3, 7, 9)
  println(findSecondMinimum(list))

  //  Empty List
  val emptyList = List.empty[Int]
  println(findSecondMinimum(emptyList))

  //  List with one Element
  val oneElementList = List(1)
  println(findSecondMinimum(oneElementList))

}
