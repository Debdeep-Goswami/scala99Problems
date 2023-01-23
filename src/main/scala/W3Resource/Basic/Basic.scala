package W3Resource.Basic

object Basic extends App {

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

  //  5. Write a Scala program to check a given integer and return true if it is within 20 of 100 or 300.
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

  //  9. Write a Scala program to create a new string which is 4 copies of the 2 front characters
  //  of a given string. If the given string length is less than 2 return the original string.

  def fun9(string: String): String = {
    if (string.length < 2) string
    else string.substring(0, 2) * 4
  }

  //  println(fun9("Debdeep"))
  //  println(fun9("D"))

  //  10. Write a Scala program to create a new string with the last char added at the front
  //  and back of a given string of length 1 or more.

  def fun10(string: String): String = {
    val length = string.length
    val last = if (length > 0) string.charAt(length - 1) else ""
    last + string + last
  }

  //  println(fun10("DebdeeP"))
  //  println(fun10(""))

  //  11. Write a Scala program to check whether a given positive number is a multiple of 3
  //  or a multiple of 7.

  def fun11(number: Int): Boolean = number % 3 == 0 || number % 7 == 0

  //  println(fun11(10))
  //  println(fun11(49))
  //  println(fun11(9))

  //  12. Write a Scala program to create a new string taking the first 3 characters of a
  //  given string and return the string with the 3 characters added at both the front and
  //  back. If the given string length is less than 3, use whatever characters are there.

  def fun12(string: String): String = {
    if (string.length < 3) string * 3
    else {
      val first3 = string.substring(0, 3)
      first3 + string + first3
    }
  }

  //  println(fun12("deb"))
  //  println(fun12("debdeep"))
  //  println(fun12("de"))

  //  13. Write a Scala program to check whether a given string starts with 'Sc' or not.
  def fun13(string: String): Boolean = string.startsWith("Sc")

  //  println(fun13("School"))
  //  println(fun13("Debdeep"))

  //  14. Write a Scala program to check whether one of the given temperatures is less
  //  than 0 and the other is greater than 100.
  def fun14(temp1: Int, temp2: Int): Boolean = (temp1 < 0 && temp2 > 100) || (temp1 > 100 && temp2 < 0)

//  println(fun14(120, -1))
//  println(fun14(-1, 120))
//  println(fun14(2, 120))

  //  15. Write a Scala program to check two given integers whether either of them is in
  //  the range 100..200 inclusive.

  def fun15(no1: Int, no2: Int): Boolean = (no1>=100 && no2<=200) || (no2>=100 && no2<=200)

//  println(fun15(100, 199));
//  println(fun15(250, 300));
//  println(fun15(105, 190));

}
