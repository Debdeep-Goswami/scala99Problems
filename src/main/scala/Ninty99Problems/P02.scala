package Ninty99Problems

import scala.annotation.tailrec

object P02 extends App {

  //  Problem Statement
  //  P02 (*) Find the last but one element of a list.

  //  Solution 1 using Built in function
  val emptyList = List();
  val myList = List(1, 2, 3, 4, 5, 6)

  println(myList.reverse.tail.head)

  //  Solution 2 with pattern matching
  @tailrec
  def findSecondLast[A](list: List[A]): Option[A] = {
    list match {
      case x :: y :: Nil => Some(x)
      case x :: Nil => None
      case _ :: tail => findSecondLast(list.tail)
      case _ => None
    }
  }

  display(findSecondLast(emptyList))
  display(findSecondLast(myList))

  //  Utility function to display
  def display[A](ans: Option[A]) = {
    println({
      if (ans.isEmpty) "No Element found"
      else ans.get
    })
  }

  //  Solution 3 Using HOF (fold function)
//  println(myList.fold(0)((acc, ele) => ))
}
