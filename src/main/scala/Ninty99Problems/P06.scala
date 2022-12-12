package Ninty99Problems

import scala.annotation.tailrec

object P06 extends App {
  //  Problem Statement
  //  P06 (*) Find out whether a list is a palindrome.

  //  Solution 1 with Built in function
  def isPalindrome[A](ls: List[A]): Boolean = ls == ls.reverse

  println("\nOutput of Solution 1\n")

  //  Proper Input
  val list = List(1, 2, 3, 2, 1)
  println(isPalindrome(list))

  val list2 = List(1, 2, 3, 4, 5)
  println(isPalindrome(list2))

  //  List with One Element
  val oneElementList = List(1)
  println(isPalindrome(oneElementList))

  //  Empty List
  val emptyList = List.empty[Int]
  println(isPalindrome(emptyList))

  //  Solution 2 by recursion
  def isPalindrome_v2(list: List[Int]): Boolean = {
    @tailrec
    def inner(list: List[Int], ans: Boolean): Boolean = {
      if (list.isEmpty) ans
      else if (list.size == 1) true
      else if (list.head == list.last) inner(list.init.tail, true)
      else false
    }

    inner(list, true)
  }

  println("\nOutput of Solution 2\n")

  //  Proper Input
  println(isPalindrome_v2(list))

  println(isPalindrome_v2(list2))

  //  List with One Element
  println(isPalindrome_v2(oneElementList))

  //  Empty List
  println(isPalindrome_v2(emptyList))
}
