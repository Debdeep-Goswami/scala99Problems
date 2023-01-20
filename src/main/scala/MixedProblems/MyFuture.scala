package MixedProblems

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object MyFuture extends App {
  println("First Line")   //  1
  val f = Future {
    println("From Future")  //  2
  }
  Thread.sleep(1) //  This will print 2 before 3
  println("Last Line")    //  3
}
