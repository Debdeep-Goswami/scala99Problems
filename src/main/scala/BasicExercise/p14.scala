package BasicExercise

object p14 {
  /*

  14) Merge two sorted list one sorted list:
  def merge( list1:List[Int], list2:List[Int]):List[Int]=
  {     //code here
  }
  Eg:List(1,3,5) and List(2,4,6 ) pass into meger then it  will resturn List(1,2,3,4,5,6)

  */

  def merge(list1: List[Int], list2: List[Int]): List[Int] = {
    def inner(list1: List[Int], list2: List[Int], mergedList: List[Int]): List[Int] = {
      if (list1.isEmpty && list2.isEmpty) mergedList
      else if (list1.isEmpty) mergedList ::: list2
      else if (list2.isEmpty) mergedList ::: list1
      else if (list1.head <= list2.head) inner(list1.tail, list2, mergedList :+ list1.head)
      else inner(list1, list2.tail, mergedList :+ list2.head)
    }

    inner(list1, list2, List.empty[Int])
  }

  def main(args:Array[String]) : Unit = {
    val list1:List[Int] = List(1,3,5,6,100)
    val list2:List[Int] = List(2,4,7,8,9)
    println(merge(list1, list2))
  }
}
