package Ninty99Problems

import scala.annotation.tailrec

object P08 extends App {

  //  Problem Statement
  //  P08 (**) Eliminate consecutive duplicates of list elements


  //  Solution
  val list: List[Int] = List(1, 2, 2, 3, 4, 4, 5, 5, 6, 6, 6, 7)
  val list2: List[Char] = List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')

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

  //  Using fold function
  println(
    list.foldRight(List[Int]())((h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    )
  )

  //  Using Generics with fold
  def dropDuplicate_v2[T](list: List[T]): List[T] = {
    list.foldRight(List[T]())((h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    )
  }

  println(dropDuplicate_v2(list))
  println(dropDuplicate_v2(list2))
}
