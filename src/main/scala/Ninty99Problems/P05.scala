package Ninty99Problems

import scala.annotation.tailrec

object P05 extends App {

  //  Problem Statement
  //  P05 (*) Reverse a list.

  //  Solution 1 with Built in function

  val list = List(1, 2, 3, 4, 5)
  val emptyList = List()


  println(list)
  println(list.reverse)
  println(emptyList.reverse)

  //  Solution 2 with Recursion
  def reverse[T](list: List[T]): List[T] = {
    @tailrec
    def inner(list: List[T], reversedList: List[T]): List[T] = {
      if (list.isEmpty) reversedList
      else inner(list.tail, list.head :: reversedList)
    }

    inner(list, List())
  }

  println(list)
  println(reverse(list))
  println(reverse(emptyList))

  //  Solution 3 with Pattern Matching
  def reverse_v2[T](list:List[T]): List[T] = {
    @tailrec
    def inner[T](list : List[T],reversedList:List[T]) : List[T] ={
      list match {
        case Nil => reversedList
        case h :: tail => inner(list.tail,h::reversedList)
      }
    }
    inner(list,List())
  }

  println(list)
  println(reverse_v2(list))
  println(reverse_v2(emptyList))
}
