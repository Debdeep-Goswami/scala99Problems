package MixedProblems

object FactorialWithLoop extends App {

  def findFactorial(number: Int): Option[BigInt] = {
    var i: BigInt = 1
    var ans: BigInt = 1
    if (number < 0) None
    else {
      while (i <= number) {
        ans = ans * i
        i+=1
      }
      Some(ans)
    }
  }

  //  Utility Function to display
  def display(ans: Option[BigInt]): Unit = {
    if (ans.isEmpty) println("Factorial of a Negative number is not possible")
    else println(ans.get)
  }

  //  Proper Input
  display(findFactorial(5))

  //  Zero as input
  display(findFactorial(0))

  //  Negative Number as Input
  display(findFactorial(-5))
}
