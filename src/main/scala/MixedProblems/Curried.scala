package MixedProblems

object Curried extends App {

  val superAdder: Int => (Int => Int) = x => (y => x + y)
  val adder3 = superAdder(3)

  println(adder3(7))

  println(superAdder(3)(7)) //  Curried Function


  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  val plus1 = (x: Int) => x + 1

  println(nTimes(plus1, 5, 10))


  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) ((x: Int) => x)
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))
  }

  val plus10 = nTimesBetter(plus1,10)
  println(plus10(20))

}
