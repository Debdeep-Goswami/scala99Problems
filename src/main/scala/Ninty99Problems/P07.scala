package Ninty99Problems

object P07 extends App {

  //  Problem Statement
  //  P07 (**) Flatten a nested list structure.

  //  Solution
  val list = List(1, 2, List(3, 4), List(5, 6, 7), List("abc"), "xyz")

  val list2 = List(List(1, 2), List(3, 4))

  def myFlatten(list: List[Any]): List[Any] = {
    list.flatMap({
      case x: List[_] => myFlatten(x)
      case x: Any => List(x)
    })
  }

  println("Normal List = "+list)
  println("Flatten List = "+myFlatten(list))

  println("Normal List = " + list2)
  println("Flatten List = " + myFlatten(list2))
}
