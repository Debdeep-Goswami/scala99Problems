package MixedProblems

import scala.annotation.tailrec

object PalindromeOrNot extends App {
  def isPalindrome(number: Option[Int]): Option[Boolean] = {
    if (number.isEmpty) None
    else if (number == reverse(number.get)) Some(true)
    else Some(false)
  }

  def reverse(i: Int): Int = {
    @tailrec
    def inner(i: Int, ans: Int): Int = {
      if (i == 0) ans
      else inner(i / 10, ans * 10 + i % 10)
    }

    inner(i, 0)
  }

  //  Correct Input
  println(isPalindrome(Some(121)))
  println(isPalindrome(Some(123)))

  //  Invalid Input
  println(isPalindrome(None))

}
