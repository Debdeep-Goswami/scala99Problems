package Ninty99Problems

import scala.annotation.tailrec
import scala.collection.immutable.Stream.Empty

object P03 extends App {
  //  Problem Statement
  //  P03 (*) Find the Kth element of a list.


  //  Solution 1 using Built in Function
  def findKthElement[T](k:Int,list:List[T]): Option[T] = {
    if(list.isEmpty) None
    else if(list.size-1<k) None
    else Some(list(k))
  }

  //  Utility function to display
  def display[T](ans :Option[T]):Unit ={
    println(
      if(ans.isEmpty) "No Such element found"
      else ans.get
    )
  }

  val list: List[Int] = List(1, 2, 4, 65, 23, 59, 8, 82, 26)
  val k: Int = 5
  //  With Proper input
  display(findKthElement(k,list))

  //  With Empty List
  display(findKthElement(k,Empty.toList))

  //  with k more than the size of the list
  display(findKthElement(100,list))


  //  Solution 2 with Recursion
  @tailrec
  def findKthElement_v2[T](k:Int,list: List[T],counter:Int): Option[T] = {
    if(list.isEmpty) None
    else if(counter>k) None
    else if(counter==k) Some(list.head)
    else findKthElement_v2(k,list.tail,counter+1)
  }

  //  With Proper input
    display(findKthElement_v2(k,list,0))

  //  With Empty List
    display(findKthElement_v2(k,Empty.toList,0))

  //  with k more than the size of the list
  display(findKthElement(100, list))
}
