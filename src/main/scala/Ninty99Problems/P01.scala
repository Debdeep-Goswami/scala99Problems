package Ninty99Problems

import scala.annotation.tailrec

object P01 extends App {
  //  Problem Statement
  //  P01 (*) Find the last element of a list

  //  Solution 1 using Built in function
  def lastBuiltIn[A](list: List[A]): Option[A] = {
    if (list.isEmpty) None
    else Some(list.last)
  }

  //  Solution 2 using functional Programming Approach
  @tailrec
  def lastRecursive[A](list: List[A]): Option[A] = {
    list match {
      case x :: Nil => Some(x)
      case _ :: tail => lastRecursive(list.tail)
      case _ => None
    }
  }

  //  Utility function to display result
  def display[A](ans: Option[A]): Unit = {
    println({
      if (ans.isEmpty) "No Element found"
      else ans.get
    })
  }

  val emptyList = List();
  val myList = List(1, 1, 2, 3, 5, 8)
  display(lastBuiltIn(myList))
  display(lastBuiltIn(emptyList))

  //  Solution 3 Using HOF (fold function)
  println(myList.fold(0)((acc,ele)=>
    ele
  ))
}
