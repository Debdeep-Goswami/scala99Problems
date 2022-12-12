package MixedProblems

import scala.annotation.tailrec

object SecondMinimum extends App {
    def findSecondMinimum(list: List[Int]): Option[Int] = {
      @tailrec
      def inner(min: Int, secondMin: Int, list: List[Int]): Option[Int] = {
        if (list.isEmpty) Some(secondMin)
        else if (list.head < min) inner(list.head, min, list.tail)
        else if (list.head < secondMin) inner(min, list.head, list.tail)
        else inner(min, secondMin, list.tail)
      }

      if (list.size < 2) None
      else inner(Integer.MAX_VALUE, Integer.MAX_VALUE, list)
    }

    //  Proper Input
    val list: List[Int] = List(1, 4, 0, 6, 8, 5, 5, 7, 9)
    println(findSecondMinimum(list))

    //  Empty List
    val emptyList = List.empty[Int]
    println(findSecondMinimum(emptyList))

    //  List with one Element
    val oneElementList = List(1)
    println(findSecondMinimum(oneElementList))

  def findSecondMinimum_v2(list: List[Int]): Option[Int] = {
    @tailrec
    def inner(list: List[Int], min: Option[Int], secondMin: Option[Int]): Option[Int] = {
      if (list.isEmpty) secondMin

      else if (min.isEmpty) inner(list.tail, Some(list.head), secondMin)

      else if(secondMin.isEmpty && list.head<min.get) inner(list.tail, Some(list.head),min)
      else if(secondMin.isEmpty && list.head>min.get) inner(list.tail,min,Some(list.head))

      else if(min.get>list.head && secondMin.get>list.head) inner(list.tail, Option(list.head), min)
      else if(min.get>list.head && secondMin.get<list.head) inner(list.tail,Option(list.head),secondMin)

      else if (secondMin.get > list.head) inner(list.tail, min, Some(list.head))

      else inner(list.tail, min, secondMin)
    }
    inner(list, None, None)
  }

    //  Proper Input
    val list2: List[Int] = List(1, 4, 0, 6, 8, 5, 5, 7, 9)
    println(findSecondMinimum_v2(list2))

    //  Empty List
    val emptyList2 = List.empty[Int]
    println(findSecondMinimum_v2(emptyList2))

    //  List with one Element
    val oneElementList2 = List(1)
    println(findSecondMinimum_v2(oneElementList2))
}
