package MixedProblems

import scala.annotation.tailrec

object SecondMinimum extends App {

  def findSecondMinimum(list: List[Int]): Int = {
    @tailrec
    def inner(max: Int, secondMax: Int, list: List[Int]): Int = {
      if(list.isEmpty) secondMax
      else if (list.head > max) inner(list.head,max,list.tail)
      else if(list.head>secondMax) inner(max,list.head,list.tail)
      else inner(max, secondMax, list.tail)
    }
    inner(Integer.MIN_VALUE,Integer.MIN_VALUE,list)
  }

  //  Not working for generics
//  def findSecondMinimum[T](list: List[T]): Option[T] = {
//    @tailrec
//    def inner(max: T, secondMax: T, list: List[T]): Option[T] = {
//      if (list.isEmpty) Some(secondMax)
//      else if (list.head > max) inner(list.head, max, list.tail)
//      else if (list.head > secondMax) inner(max, list.head, list.tail)
//      else inner(max, secondMax, list.tail)
//    }
//
//    inner(Integer.MIN_VALUE, Integer.MIN_VALUE, list)
//  }

  //  Proper Input
  val list:List[Int] = List(1,4,2,6,8,5,3,7,9)
  println(findSecondMinimum(list))

  //  Empty List
  val emptyList = List()
  println(findSecondMinimum(emptyList))

  //  List with one Element
  val oneElementList = List(1)
  println(findSecondMinimum(oneElementList))
}
