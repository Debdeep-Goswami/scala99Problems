package BasicExercise

object P03 {

  /*
  3) def sum( opt1:Option[Int],opt2: Option[Int]):Option[Int]={
  //code
  }
   */


  def sum(opt1: Option[Int], opt2: Option[Int]): Option[Int] = {
    if (opt1.isDefined) if (opt2.isDefined) Some(opt1.get + opt2.get) else Some(opt1.get)
    else if (opt2.isDefined) opt2
    else None
  }

  def main(args: Array[String]): Unit = {

    //  With Valid Input
    println(sum(Some(1), Some(2)))

    //  With One Missing
    println(sum(Some(1), None))
    println(sum(None, Some(2)))

    //  With Both Missing
    println(sum(None, None))

  }
}
