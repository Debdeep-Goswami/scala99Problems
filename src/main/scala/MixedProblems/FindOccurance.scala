package MixedProblems

object FindOccurance {

  def findOccurance(array: Array[Char],char: Char): Unit = {
    def inner(array: Array[Char], char: Char, currentIndex: Int, first: Int, last: Int): Unit = {
      if (array.size == currentIndex) println(char + " in " + array.mkString("") + " appeared first at index " + first + " and last at index " + last)
      else {
        if (char == array(currentIndex)) {
          if (first == -1) inner(array, char, currentIndex+1, currentIndex, last)
          else inner(array, char, currentIndex+1, first, currentIndex)
        } else inner(array, char, currentIndex + 1, first, last)
      }
    }
    inner(array,char,0,-1,-1)
  }

  def main(args: Array[String]): Unit = {
    findOccurance("debdeep".toCharArray,'e')
    findOccurance("debdeep".toCharArray,'d')
  }

}
