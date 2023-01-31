//package MixedProblems
//
//object Duplicate {
//
//  def printDuplicates(list: List[Int]): Unit = {
//    val uniqueList: List[Int] = List.empty[Int]
//    list.foldLeft(List.empty[Int])((acc, cur) => {
//      if (acc.contains(cur)) acc :+ cur else uniqueList :+ cur
//    })
//  }
//
//  def main(args: Array[String]): Unit = {
//
//    val list = List(1, 2, 2, 1, 3, 3, 4, 5, 6, 2, 1, 5)
//    printDuplicates(list)
//  }
//
//}
