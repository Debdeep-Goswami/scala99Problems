package MixedProblems

object CaseClass {

  case class Employee(firstName: String, lastName: String)

  case class NewEmployee(var firstName: String, var lastName: String)

  def main(args: Array[String]): Unit = {
    val deb = Employee("Debdeep", "Goswami")
    println(deb)
    println(deb.firstName)
    println(deb.lastName)
    //    deb.lastName = "Nothing"  //  Not possible as it is by default val


    val dev = NewEmployee("Debdeep", "Goswami")
    println(dev)
    println(dev.firstName)
    println(dev.lastName)
    println(dev==deb)
    dev.lastName = "test"
    println(dev)

    val deb2 = Employee("Debdeep","Goswami")
    println(deb == deb2)
    println(deb.equals(deb2))
  }



}
