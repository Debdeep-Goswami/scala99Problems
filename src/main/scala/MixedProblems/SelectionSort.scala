package MixedProblems

object SelectionSort extends App {

  //  With List
  def findMin(list: List[Int]): Option[Int] = {
    def inner(list: List[Int], min: Option[Int]): Option[Int] = {
      if (list.isEmpty) min
      else if (min.isEmpty) inner(list.tail, Some(list.head))
      else if (min.get > list.head) inner(list.tail, Some(list.head))
      else inner(list.tail, min)
    }

    inner(list, None)
  }

  def selectionSortList(list: List[Int]): List[Int] = {
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
  //  println("Before Sorting = " + list)
  //  println("After Sorting = " + selectionSort(list))


  //  With Array

  def findMinArray(array: Array[Int]): Option[Int] = {
    def inner(array: Array[Int], min: Option[Int]): Option[Int] = {
      if (array.isEmpty) min
      else {
        if (min.isEmpty) inner(array.tail, Some(array.head))
        else if (min.get > array.head) inner(array.tail, Some(array.head))
        else inner(array.tail, min)
      }
    }

    inner(array, None)
  }

  def selectionSortArray(array: Array[Int]): Array[Int] = {
    def inner(array: Array[Int], sortedArray: Array[Int]): Array[Int] = {
      if (array.isEmpty) sortedArray
      else {
        val min = findMinArray(array)
        inner(array.filter(_ != min.get), sortedArray :+ min.get)
      }
    }

    inner(array, Array.empty[Int])
  }

  val array: Array[Int] = Array(9, 8, 7, 6, 0, 5, 4, 3, 2, 1)
  println("Before Sorting = " + array.mkString(" "))
  println("After Sorting = " + selectionSortArray(array).mkString(" "))


  //  With Swapping (Followed Actual Algo. With Recursion)

  def selectionSortTailRecursive(unsortedArray: Array[Int]): Array[Int] = {
    def inner(unsortedArray: Array[Int], sortedArray: Array[Int]): Array[Int] = {
      if (unsortedArray.isEmpty) sortedArray
      else {
        val minIndex = findMinElementIndex(unsortedArray)
        val minElement = unsortedArray(minIndex)
        val tempArray = unsortedArray.updated(minIndex, unsortedArray(0)).updated(0, minElement)
        inner(tempArray.tail, sortedArray :+ minElement)
      }
    }

    inner(unsortedArray, Array.empty[Int])
  }

  def findMinElementIndex(array: Array[Int]): Int = {
    def inner(start: Int, minIndex: Int): Int = {
      if (start == array.size) minIndex
      else inner(start + 1, if (array(minIndex) > array(start)) start else minIndex)
    }

    inner(0, 0)
  }
  println("Before Sorting = " + array.mkString(" "))
  println("After Sorting = " + selectionSortTailRecursive(array).mkString(" "))





  //  Not Required kept for future understanding

  //  def findMinWithIndex(array: Array[Int]): (Int, Int) = {
  //    def inner(array: Array[Int], min: Option[Int], index: Option[Int]): (Int, Int) = {
  //      if (array.isEmpty) (min.get, index.get)
  //      else if (min.isEmpty) inner(array.tail, Some(array.head), Some(0))
  //      else if (min.get > array.head) inner(array.tail, Some(array.head), Some(index.get + 1))
  //      else inner(array.tail, min, index)
  //    }
  //
  //    inner(array, None, None)
  //  }
  //
  //  println(findMinWithIndex(array))
}
