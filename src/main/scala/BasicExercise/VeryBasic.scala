package BasicExercise

import java.lang

object VeryBasic extends App {

  //  1. Write a Scala program to print "Hello, world" and version of the Scala language.
  def fun1(): Unit = {
    println("Hello World!")
    println("Scala Version = " + util.Properties.versionString)
  }

  //  fun1()

  //  2. Write a Scala program to compute the sum of the two given integer values.
  //  If the two values are the same, then return triples their sum.

  def fun2(num1: Int, num2: Int): Int = {
    if (num1 == num2) (num1 + num2) * 3 else num1 + num2
  }

//  println(fun2(10, 20))
//  println(fun2(10, 10))

  //  3. Write a Scala program to get the absolute difference between n and 51.
  //  If n is greater than 51 return triple the absolute difference.

  def fun3(n: Int): Int = if(n>51) Math.abs(n-51)*3 else Math.abs(n-51)

  println(fun3(51))
  println(fun3(20))
  println(fun3(60))
}
