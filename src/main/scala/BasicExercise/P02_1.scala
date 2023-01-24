//package BasicExercise
//
//import scala.annotation.tailrec
//
//object P02_1 {
//
//  /*
//    def rotate(a:Array[Int], r:Int):Array[Int]={          ////          }
//   */
//
//
//  def rotate(a: Array[Int], r: Int): Array[Int] = {
//    @tailrec
//    def inner(a: Array[Int], r: Int, output: Array[Int]): Array[Int] = {
//      if (a.size - r <= 0) a
//
//    }
//
//    inner(a, r, Array.empty[Int])
//  }
//
//  def main(args: Array[String]): Unit = {
//    val a: Array[Int] = Array(1, 2, 3, 4, 5)
//    println(rotate(a, 3).mkString(" "))
//  }
//
//}
