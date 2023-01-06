package MixedProblems

import scala.io.Source

object CSVtoJson {

  def readHead(fileSource : String) : String = {

    //  Opening the file
    val fileBuffer = Source.fromFile(fileSource)

    //  Reading the first line of the file
    val output = fileBuffer.getLines().next()

    //  Closing the file
    fileBuffer.close()

    //  Return the first line
    output
  }
  def readTail(fileSource:String) : Iterator[String] = {

    //  Opening the file
    val fileBuffer = Source.fromFile(fileSource)

    //  Reading the whole content of the file
    val fileContent = fileBuffer.getLines()

    //  Reading the first line (To discard)
    fileContent.next()

    //  Returning the rest of the lines
    fileContent
  }

  def csvToJson(fileSource:String) : Unit = {
    val head = readHead(fileSource)
    val body = readTail(fileSource)

  }

  def fileRead(fileSource :String) : Unit = {
    val fileBuffer = Source.fromFile(fileSource)
    val fileContent = fileBuffer.getLines()
    val headerRow = fileContent.next()
    println("Header = \n"+headerRow)
    while (fileContent.hasNext) {
      println(fileContent.next())
    }
  }
  def main(args:Array[String]) : Unit = {
    val fileSource = "/home/goswami/Documents/Scala/Scala99Problems/src/resources/Test.csv"
//    fileRead(fileSource)

    println(readHead(fileSource))
    readTail(fileSource).foreach(println)
  }
}
