package MixedProblems

object BinarySearch extends App {

  def divideListByMid(list: List[Int]): (Option[Int], List[Int], List[Int]) = {
    def inner(list: List[Int], start: Int, size: Int, leftPart: List[Int], rightPart: List[Int]): (Option[Int], List[Int], List[Int]) = {
      if (list.size == 0) (None, leftPart, rightPart)
      else if (start == size / 2) (Some(list.head), leftPart, rightPart)
      else inner(list.tail, start + 1, size, leftPart :+ list.head, list.tail.tail)
    }

    inner(list, 0, list.size, List.empty[Int], List.empty[Int])
  }

  def binarySearch(list: List[Int], searchElem: Int): Boolean = {
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

  println(bin