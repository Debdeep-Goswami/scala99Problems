package Ninty99Problems

object P05 extends App {

  //  Problem Statement
  //  P04 (*) Find the number of elements of a list.

  //  Solution 1 with Built in function

  val list = List(1, 2, 3, 4, 5)
  println(list)
  println(list.reverse)


  //  Solution 2 with Recursion
  def reverse[T](list: List[T]): List[T] = {
    def inner(list: List[T], reversedList: List[T]): List[T] = {
      if (list.isEmpty) reversedList
      else inner(list.tail, list.head :: reversedList)
    }

    inner(list, List())
  }

  println(list)
  println(reverse(list))
}
