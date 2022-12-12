package Ninty99Problems

object P06 extends App {
  //  Problem Statement
  //  P06 (*) Find out whether a list is a palindrome.

  //  Solution 1 with Built in function
  def isPalindrome[A](ls: List[A]): Boolean = ls == ls.reverse

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
}
