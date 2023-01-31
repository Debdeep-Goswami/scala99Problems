package MixedProblems

import scala.annotation.tailrec

object StringReverse {

  def stringReverse(string: String): Unit = {
    @tailrec
    def inner(sourceString: String, resultString: String) : Unit = {
      if(sourceString.isEmpty) println(resultString)
      else inner(sourceString.tail, sourceString.head+resultString)
    }
    inner(string,"")
  }

  def wordReverse(string: String): Unit = {
    val wordList: List[String] = string.split(" ").toList

    wordList.map(x => {
      println(x.foldRight("")((cur, acc) => acc + cur))
    })
  }

  def sentenceReverse(string: String): Unit = {
    val wordList = string.split(" ").toList

    println(wordList.foldRight("")((cur, acc) => acc + cur + " "))
  }

  def main(args: Array[String]): Unit = {
    val string: String = "Hi this is Debdeep"
    //    wordReverse(string)
    //    sentenceReverse(string)
    stringReverse("Debdeep")
  }
}
