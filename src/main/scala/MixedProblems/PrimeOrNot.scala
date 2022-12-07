package MixedProblems

import scala.annotation.tailrec

object PrimeOrNot extends App{

  def findPrimeOrNot(number:Int) :Option[Boolean] = {
    if(number<2) None
    else{
      @tailrec
      def inner(number: Int,divisor:Int):Option[Boolean] ={
        if(divisor>=number) Some(true)
        else if(number%divisor==0) Some(false)
        else inner(number,divisor+1)
      }
      inner(number,2)
    }
  }

  //  Utility function to display
  def display(ans:Option[Boolean]) :Unit ={
    if(ans.isEmpty) println("Prime number starts from 2")
    else println(ans.get)
  }

  //  Proper Input
  display(findPrimeOrNot(10))

  //  Zero as input
  display(findPrimeOrNot(0))

  //  Negative Number as Input
  display(findPrimeOrNot(-5))
}
