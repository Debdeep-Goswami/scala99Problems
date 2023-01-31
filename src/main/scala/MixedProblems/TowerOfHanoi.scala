package MixedProblems

object TowerOfHanoi {

  def towerOfHanoi(disk: Int, source: String, helper: String, destination: String): Unit = {
    if(disk==1) println(disk + " moved from " + source + " to " + destination)
    else{
      towerOfHanoi(disk - 1, source, destination, helper)
      println(disk + " moved from " + source + " to " + destination)
      towerOfHanoi(disk - 1, helper, source, destination)
    }
  }

  def main(args: Array[String]): Unit = {
    towerOfHanoi(3,"A","B","C")
  }
}
