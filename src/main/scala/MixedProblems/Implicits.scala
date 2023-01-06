package MixedProblems

object Implicits extends App {
  trait Add[T] {
    def add(x: T, y: T): T
  }

  implicit object intAdd extends Add[Int] {
    override def add(x: Int, y: Int): Int = x + y
  }

  implicit object StringAdd extends Add[String] {
    override def add(x: String, y: String): String = x + " " + y
  }

  def adddition[T](x: T, y: T)(implicit implicitObject: Add[T]): T = {
    implicitObject.add(x,y)
  }

  println(adddition(5,10))
  println(adddition("Debdeep","Goswami"))
}
