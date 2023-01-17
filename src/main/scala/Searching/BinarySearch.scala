package Searching

import scala.annotation.tailrec

object BinarySearch extends App {

  //  With List
  def divideListByMid(list: List[Int]): (Option[Int], List[Int], List[Int]) = {
    @tailrec
    def inner(list: List[Int], start: Int, size: Int, leftPart: List[Int], rightPart: List[Int]): (Option[Int], List[Int], List[Int]) = {
      if (list.size == 0) (None, leftPart, rightPart)
      else if (start == size / 2) (Some(list.head), leftPart, rightPart)
      else inner(list.tail, start + 1, size, leftPart :+ list.head, list.tail.tail)
    }

    inner(list, 0, list.size, List.empty[Int], List.empty[Int])
  }

  def binarySearch(list: List[Int], searchElem: Int): Boolean = {
    @tailrec
    def inner(list: List[Int], searchElem: Int, ans: Boolean): Boolean = {
      val (mid, leftHalf, rightHalf) = divideListByMid(list)
      if (list.isEmpty) ans
      else if (searchElem == mid.get) true
      else if (searchElem > mid.get) inner(rightHalf, searchElem, ans)
      else inner(leftHalf, searchElem, ans)
    }

    inner(list, searchElem, false)
  }

  val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

  //  Element not present
  var searchElement = 10
  println(list + " Searched Element " + searchElement + " = " + binarySearch(list, searchElement))

  searchElement = 0
  println(list + " Searched Element " + searchElement + " = " + binarySearch(list, searchElement))


  //  Element present
  searchElement = 4
  println(list + " Searched Element " + searchElement + " = " + binarySearch(list, searchElement))

  //  Edge cases
  searchElement = 1
  println(list + " Searched Element " + searchElement + " = " + binarySearch(list, searchElement))

  searchElement = 9
  println(list + " Searched Element " + searchElement + " = " + binarySearch(list, searchElement))


  //  Empty List
  val emptyList = List.empty[Int]
  searchElement = 100
  println(emptyList + " Searched Element " + searchElement + " = " + binarySearch(emptyList, searchElement))

  //  One Element List
  val list1: List[Int] = List(5)
  //  Element not present
  searchElement = 100
  println(list1 + " Searched Element " + searchElement + " = " + binarySearch(list1, searchElement))

  //  Element present
  searchElement = 5
  println(list1 + " Searched Element " + searchElement + " = " + binarySearch(list1, searchElement))


  //  _____________________________________________________

  //  With Array
  def binarySearch_v2(array: Array[Int], searchElem: Int): Boolean = {
    @tailrec
    def inner(array: Array[Int], searchElem: Int, ans: Boolean): Boolean = {
      val mid = array.length / 2
      if (array.isEmpty) ans
      else if (array(mid) == searchElem) true
      else if (searchElem > array(mid)) inner(array.slice(mid + 1, array.size), searchElem, ans)
      else inner(array.slice(0, mid), searchElem, ans)
    }

    inner(array, searchElem, false)
  }

  val array: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)

  //  Element not present
  searchElement = 10
  println(array.mkString(" ") + " Searched Element " + searchElement + " = " + binarySearch_v2(array, searchElement))

  searchElement = 0
  println(array.mkString(" ") + " Searched Element " + searchElement + " = " + binarySearch_v2(array, searchElement))


  //  Element present
  searchElement = 4
  println(array.mkString(" ") + " Searched Element " + searchElement + " = " + binarySearch_v2(array, searchElement))

  //  Edge cases
  searchElement = 1
  println(array.mkString(" ") + " Searched Element " + searchElement + " = " + binarySearch_v2(array, searchElement))

  searchElement = 9
  println(array.mkString(" ") + " Searched Element " + searchElement + " = " + binarySearch_v2(array, searchElement))


  //  Empty Array
  val emptyArray = Array.empty[Int]
  searchElement = 100
  println(emptyArray.toList + " Searched Element " + searchElement + " = " + binarySearch_v2(emptyArray, searchElement))

  //  One Element Array
  val array1: Array[Int] = Array(5)
  //  Element not present
  searchElement = 100
  println(array1.mkString(" ") + " Searched Element " + searchElement + " = " + binarySearch_v2(array1, searchElement))

  //  Element present
  searchElement = 5
  println(array1.mkString(" ") + " Searched Element " + searchElement + " = " + binarySearch_v2(array1, searchElement))

}
