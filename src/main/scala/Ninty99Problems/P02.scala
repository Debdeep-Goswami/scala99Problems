package Ninty99Problems

import scala.annotation.tailrec

object P02 extends App {

  //  Problem Statement
  //  P02 (*) Find the last but one element of a list.


  //  Solution 1 with pattern matching
  @tailrec
  def findSecondLast[A](list: List[A]): Option[A] = {
    list match {
      case x :: y :: Nil => Some(x)
      case x :: Nil => None
      case _ :: tail => findSecondLast(list.tail)
      case _ => None
    }
  }

  val emptyList = List();
  val myList = List(1, 1, 2, 3, 5, 8)
  display(findSecondLast(emptyList))
  display(findSecondLast(myList))

  //  Utility function to display
  def display[A](ans: Option[A]) = {
    println({
      if (ans.isEmpty) "No Element found"
      else ans.get
    })
  }
}
