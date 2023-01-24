package BasicExercise

object P07 {
  implicit class IntSquare(i:Int){
    def square: Int = i * i
  }

  class IntSquare2{
    def square2(i:Int) :Int = i*i
  }
  def main(args: Array[String]): Unit = {
    val number2 = 2
    println(number2.square)
    println(number2.square)
  }
}
