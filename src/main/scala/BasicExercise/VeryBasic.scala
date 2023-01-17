package BasicExercise

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

  def fun3(n: Int): Int = if (n > 51) Math.abs(n - 51) * 3 else Math.abs(n - 51)

  //  println(fun3(51))
  //  println(fun3(20))
  //  println(fun3(60))

  //  4. Write a Scala program to check two given integers, and return true if one of them is 30 or if their sum is 30

  def fun4(no1: Int, no2: Int): Boolean = no1 == 30 || no2 == 30 || no1 + no2 == 30

  //  println(fun4(30,60))
  //  println(fun4(20,30))
  //  println(fun4(100,20))
  //  println(fun4(20,10))

  def fun5(no1: Int): Boolean = Math.abs(100 - no1) <= 20 || Math.abs(300 - no1) <= 20

  //  println(fun5(115));
  //  println(fun5(200));
  //  println(fun5(250));
  //  println(fun5(70));
  //  println(fun5(315));

  //  6. Write a Scala program to create a new string where 'if' is added to the front of a
  //  given string. If the string already begins with 'if', return the string unchanged.
  def fun6(string: String): String = {
    if (string.startsWith("if")) string else "if " + string
  }

  //  println(fun6("if else"));
  //  println(fun6("else"));

  //  7. Write a Scala program to remove the character in a given position of a given string.
  //  The given position will be in the range 0...string length -1 inclusive.
  //  The Given position will be in the range 1 to String Length inclusive

  def fun7(string: String, position: Int): String = {

    //  The given position will be in the range 0...string length -1 inclusive.
    string.take(position) + string.drop(position + 1)

    //  The Given position will be in the range 1 to String Length inclusive
    //    string.take(position - 1) + string.drop(position)
  }

  //  println(fun7("Debdeep", 2))

  //  8. Write a Scala program to exchange the first and last characters in a given string
  //  and return the new string.

  def fun8(string: String): String = {
    if (string.isEmpty) string
    else {
      string.charAt(string.length - 1) + string.substring(1, string.length - 1) + string.charAt(0)
    }
  }

//  println(fun8("Debdeep"))

  //

}
