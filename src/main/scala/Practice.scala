import scala.annotation.tailrec

object Practice {
  /*
  Input: {2, 1, 1, 1, 3, 3, 6, 6, 7, 1}
  Output: {2, 1, 3, 6, 7}
   */

  def removeDuplicate(array: Array[Int]): Array[Int] = {
    @tailrec
    def inner(array: Array[Int], outputArray: Array[Int]): Array[Int] = {
      if (array.isEmpty) outputArray
      else if (outputArray.contains(array.head)) inner(array.tail, outputArray)
      else inner(array.tail, outputArray :+ array.head)
    }

    inner(array, Array.empty[Int])
  }

  def wordCount(input: String): Unit = {
    val tokens: List[String] = input.split(" ").toList
    val output = tokens.groupBy(a => a)
    output.map(x => println(x._1 + " -> " + x._2.length))
  }


  def main(args: Array[String]): Unit = {
    val array: Array[Int] = Array(2, 1, 1, 1, 3, 3, 6, 6, 7, 1)
    //    println("Before " + array.mkString(" "))
    //    println("After " + removeDuplicate(array).mkString(" "))

    //    println(array.foldLeft(Array.empty[Int])((acc, cur) => cur +: acc).mkString(" "))

    val string: String = "hi this is hi hi is this one"
    //    wordCount(string)

    //  Print All combinations
    val numbers: List[Int] = List(1, 2, 3)
    val chars: List[Char] = List('a', 'b', 'c')

    println(numbers.flatMap(n => chars.map(c => "" + n + c)))

    val forCombinations = for {
      n <- numbers
      c <- chars
    } yield "" + n + c

    println(forCombinations)
  }
}
