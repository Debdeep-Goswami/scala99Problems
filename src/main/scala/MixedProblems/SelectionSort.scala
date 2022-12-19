package MixedProblems

object SelectionSort extends App {
  def findMin(list: List[Int]): Option[Int] = {
    def inner(list: List[Int], min: Option[Int]): Option[Int] = {
      if (list.isEmpty) min
      else if(min.isEmpty) inner(list.tail,Some(list.head))
      else if (min.get > list.head) inner(list.tail, Some(list.head))
      else inner(list.tail, min)
    }

    inner(list, None)
  }
  def selectionSort(list: List[Int]): List[Int] = {
    def inner(list: List[Int], sortedList: List[Int]): List[Int] = {
      if (list.isEmpty) sortedList.reverse
      else {
        val min = findMin(list)
        inner(list.filter(x => x != min.get), min.get :: sortedList)
      }
    }

    inner(list, List.empty[Int])
  }

  val list: List[Int] = List(9, 8, 7, 6, 5, 4, 3, 2, 1)
  println("Before Sorting = " + list)
  println("After Sorting = " + selectionSort(list))
}
