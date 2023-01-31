object Exam2 {

  /*
uppercase last 4 chars in given string of all words -
if less than 4 then uppercase

Input = "Hi I am Debdeep"

Output = HI I AM DebDEEP


* */

  //  def modify(string: String) : Unit = {
  //    val listOfWords = string.split(" ").toList
  //
  //    listOfWords.map(x=>{
  //      if(x.size<4) println(x.toUpperCase)
  //      else{
  //        x.foldLeft(x.size-1)((acc,curr)=> if(acc<=3){
  //          print(curr.toUpper)
  //        })
  //      }
  //    })
  //
  //  }

  //  -get the difference between the largest and smallest values in an array of integers.
  //  1 2 3 4 5 6 7  = 6
  //  def getTheDifference(array: Array[Int]): Int = array.max-array.min
  //
  //  def getTheDifference2(array: Array[Int]): Int ={
  //    var min = 99
  //    array.map(x=> if(x<min) min = x else min)
  //    var max = -99
  //    array.map(x=> if(x>max) max = x else max)
  //    max-min
  //  }
  //
  //  //  check whether two given positive integers have the same last digit.
  //  def check(no1:Int, no2:Int) : Boolean = no1%10 == no2%10
  //
  //
  //  //  check whether a given character presents in a string between 2 to 4 times
  //
  //  def presentOrNot(string: String, key:Char) : Boolean = {
  //    var counter=0
  //    string.toCharArray.map(x=>{
  //      if(x==key) counter+=1
  //      else counter
  //    })
  //    counter>=2
  //  }

  def findOddNumbers(list: List[Int]): List[Int] = list.filter(_ % 2 != 0)

  def main(args: Array[String]): Unit = {
    //    modify("Hi I am Debdeep")

    val t = Array(1, 2, 3, 4, 5, 6, -7)
    //    println(getTheDifference2(t))

    //    println(check(123,7899))

    val s = "Hi I am debdeep"
    val c = 'd'
    //    println(presentOrNot(s,c))

    val list: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(findOddNumbers(list))
  }
}
