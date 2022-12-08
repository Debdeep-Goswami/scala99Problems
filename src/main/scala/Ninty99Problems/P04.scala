package Ninty99Problems

import scala.annotation.tailrec

object P04 extends App {

  //  Problem Statement
  //  P04 (*) Find the number of elements of a list.

  //  Solution 1 with Built in function
  val list = List(1, 2, 34, 6, 3, 6, 9)
  val emptyList = List.empty[Int]

  println(list.size)
  println(emptyList.size)

  println(list.length)
  println(emptyList.length)


  //  Solution 2 with recursion
  def length[T](list: List[T]): Int = {
    @tailrec
    def inner[T](list: List[T], ans: Int): Int = {
      if (list.isEmpty) ans
      else inner(list.tail, ans + 1)
    }

    inner(list, 0)
  }

  println(length(list))
  println(length(emptyList))


  //  Solution 3 with Pattern Matching
  def length_v2[T](list: List[T]): Int = {
    @tailrec
    def inner[T](list: List[T], ans: Int): Int = {
      list match {
        case Nil => ans
        case _ :: tail => inner(tail, ans + 1)
      }
    }

    inner(list, 0)
  }

  println(length_v2(list))
  println(length_v2(emptyList))


  //  Solution 4 using fold function
  println(list.fold(0){(acc,curr)=>acc+1})
  println(list.tail.fold(list.head) { (acc, curr) => acc + 1 })

  println(emptyList.fold(0){(acc,curr)=> acc+1})
  println(emptyList.tail.fold(emptyList.head) { (acc, curr) => acc + 1 })


  //  Solution 5 using reduce function
  println(list.reduce((acc,curr)=>acc+1))

  println(emptyList.reduce((acc,curr)=> acc+1))
}

