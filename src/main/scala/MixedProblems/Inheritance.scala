package MixedProblems

object Inheritance {

  class Employee{
    var salary:Float = 1000
  }
  trait WriteCode {
    def write: String
  }
  trait PlayTT {
    def play: String
  }

  class Programmer extends Employee with WriteCode with PlayTT {
    var bonus:Int = 5000

    //    println(s"Salary = $salary")
    //    println(s"Bonus = $bonus")
    override def write: String = "I can write code"

    override def play: String = "I can play TT"

  }

  def main(args: Array[String]): Unit = {
    val debdeep = new Programmer()

    println(debdeep.write)
    println(debdeep.play)
  }

}
