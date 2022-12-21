package MixedProblems

import scala.annotation.tailrec

object SetBitCount extends App {

  //  Without Option
  def countSetBits(number: Int): Int = {
    @tailrec
    def inner(number: Int, ans: Int): Int = {
      if (number == 0) ans
      else inner(number >> 1, ans + (number & 1))
    }

    inner(number, 0)
  }

  println(countSetBits(7))


  //  With Option
  def countSetBits_v2(number: Int): Option[Int] = {
    @tailrec
    def inner(number: Int, ans: Option[Int]): Option[Int] = {
      if (number == 0) ans
      else if (ans.isEmpty) inner(number >> 1, Some((number & 1)))
      else inner(number >> 1, Some(ans.get + (number & 1)))
    }

    inner(number, None)
  }

  println(countSetBits_v2(7))


  //  With Modulus operator
  def countSetBits_v3(number: Int): Int = {
    def inner(number: Int, ans: Int): Int = {
      if (number == 0) ans
      else inner(number / 2, ans + (number % 2))
    }

    inner(number, 0)
  }

  println(countSetBits_v3(7))


  //  With Modulus operator and Option

  def countSetBits_v4(number: Int): Option[Int] = {
    def inner(number: Int, ans: Option[Int]): Option[Int] = {
      if(number==0) ans
      else if(ans.isEmpty) inner(number/2,Some(number%2))
      else inner(number/2,Some(ans.get+number%2))
    }
    inner(number,None)
  }

  println(countSetBits_v4(7))

}
