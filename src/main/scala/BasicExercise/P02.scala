package BasicExercise

import scala.annotation.tailrec

object P02 {
  /*
  Reverse the List using FoldLeft / Recursion

  def reverse(list: List[Int]): List[Int] = {
    // code
  }
  */

  def reverse(list: List[Int]): List[Int] = {
    @tailrec
    def inner(list: List[Int], ans: List[Int]): List[Int] = {
      if (list.isEmpty) ans
      else inner(list.tail, list.head::ans)
    }
    inner(list,List.empty[Int])
  }

  def main(args: Array[String]): Unit = {
    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    println(list)

    //  Using tail recursion
    println(reverse(list))

    //  Using FoldLeft
    println(list.foldLeft(List.empty[Int])((acc,cur)=>cur::acc))
  }
}
