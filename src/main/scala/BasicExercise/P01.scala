package BasicExercise

import scala.annotation.tailrec

object P01 {
  /*
    Implement show function
  def show(f:Int, n:Int):List[Int] = {
   code
  }
  Example:
  f=3
  n=4
  List(1,1,1,2,2,2, ......4,4,4)

   */

  def show(f: Int, n: Int): List[Int] = {
    def inner(f: Int, n: Int, ans: List[Int]): List[Int] = {
      if (f <= 0 || n < 0) ans
      else if (n == 0) ans
      else inner(f, n - 1, fill(n, f) ::: ans)
    }

    inner(f, n, List.empty[Int])
  }

  def fill(element: Int, times: Int): List[Int] = {
    @tailrec
    def inner(ans: List[Int], element: Int, times: Int): List[Int] = {
      if (times == 0) ans
      else inner(element :: ans, element, times - 1)
    }

    inner(List.empty[Int], element, times)
  }

  def main(args: Array[String]): Unit = {
    println(show(3, 4))
  }
}
