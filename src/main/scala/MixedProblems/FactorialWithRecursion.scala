package MixedProblems

import scala.annotation.tailrec

object FactorialWithRecursion extends App{

  def findFactorial(number: BigInt) : Option[BigInt] = {
    if(number<0) None
    else{
      @tailrec
      def factorial(number: BigInt, ans: BigInt): BigInt = {
        if (number == 0) ans
        else factorial(number - 1, ans * number)
      }
      Some(factorial(number, 1))
    }
  }

  //  Utility function to display
  def display(ans: Option[BigInt]) : Unit ={
    if(ans.isEmpty) println("Factorial of a Negative number is not possible")
    else println(ans.get)
  }


  //  Proper Input
  display(findFactorial(5))

  //  Zero as input
  display(findFactorial(0))

  //  Negative Number as Input
  display(findFactorial(-5))
}
