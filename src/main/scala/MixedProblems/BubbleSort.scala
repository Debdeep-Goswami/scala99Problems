package MixedProblems

object BubbleSort extends App {
  def findMin(list: List[Int]): Int = {
    def inner(list: List[Int], min: Int): Int = {
      if (list.isEmpty) min
      else if (min > list.head) inner(list.tail, list.head)
      else inner(list.tail, min)
    }

    inner(list, Integer.MAX_VALUE)
  }

}
