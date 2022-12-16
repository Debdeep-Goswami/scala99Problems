package Ninty99Problems

import scala.annotation.tailrec

object P08 extends App {

  //  Problem Statement
  //  P08 (**) Eliminate consecutive duplicates of list elements

  val list: List[Int] = List(1, 2, 2, 3, 4, 4, 5, 5, 6, 6, 6, 7)
  val list2: List[Char] = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
  val emptyList = List.empty[Int]

  //  Solution found
    def dropDuplicate[T](list: List[T]): List[T] = {
      @tailrec
      def inner[T](list: List[T], ans: List[T]): List[T] = {
        list match {
          case h :: tail => inner(tail.dropWhile(_ == h), h :: ans)
          case nil => ans.reverse
        }
      }

      inner(list, List.empty[T])
    }

    println(dropDuplicate(list))
    println(dropDuplicate(list2))
    println(dropDuplicate(emptyList))

  //  Solution my way
  def dropDuplicate_v2[T](list: List[T]): List[T] = {
    def inner[T](list: List[T], prev: Option[T], ans: List[T]): List[T] = {
      if (list.isEmpty) ans.reverse
      else if (prev == None) inner(list, Some(list.head), list.head :: ans)
      else {
        list match {
          case x :: tail => if (x == prev.get) inner(tail, prev, ans) else inner(tail, Some(x), x :: ans)
        }
      }
    }

    inner(list, None, List.empty[T])
  }

  println(dropDuplicate_v2(list))
  println(dropDuplicate_v2(list2))
  println(dropDuplicate_v2(emptyList))
}
