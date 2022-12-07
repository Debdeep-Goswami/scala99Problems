package MixedProblems

object EvenOdd extends App{
  def checkEvenOdd(number:Int): String = if(number%2==0) "Even" else "Odd"

  println(checkEvenOdd(9))
}
