package MixedProblems

object MyOptions extends App {

  val myFirstOption : Option[Int] = Some(4)
  val noOption : Option[Int] = None

  println(myFirstOption)
  println(noOption)

  //  Unsafe APIs
  def unSafeMethod(): String = null
  val result = Option(unSafeMethod())
  println(result)

  //  Backup API
  def backupMethod() : String = "This is backup method"
  val result2 = Option(backupMethod())
  println(result2)

  val chainResult = Option(unSafeMethod()).orElse(Option(backupMethod()))
  println(chainResult)

  val chainResult2 = Option(unSafeMethod()) orElse Option(backupMethod())
  println(chainResult2)

  //  Better Implementation of the above two APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("This is better backup method")

  val betterChainResult = betterUnsafeMethod().orElse(betterBackupMethod())
  println(betterChainResult)

  val betterChainResult2 = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterChainResult2)

}
