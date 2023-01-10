package DynamicProgramming

object SubSetSum {

  //  Recursive Solution
  def subSetSum(number: Array[Int], sum: Int): Boolean = {

    //  Base condition
    if (sum == 0) true
    else if (number.isEmpty) false
    else {
      //  Choice Diagram

      //  If not possible to add
      if (number.head > sum) subSetSum(number.tail, sum)

      //  If Possible to add
      else subSetSum(number.tail, sum) || subSetSum(number.tail, sum - number.head)
    }
  }

  //  ********************* Memoization Solution ****************************

  //  Table to store the data
  var table: Array[Array[Boolean]] = null

  def subSetSumMemoization(number: Array[Int], sum: Int): Boolean = {

    //  Base condition
    if (sum == 0) true
    else if (number.isEmpty) false

    //  Choice Diagram
    else {
      //Special case to check from the table
      if (table(number.size)(sum) != false) table(number.size)(sum)

      //  If not possible top add
      else if (number.head > sum) {
        table(number.size)(sum) = subSetSumMemoization(number.tail, sum)
        table(number.size)(sum)
      } else {
        //  If Possible to add
        table(number.size)(sum) = subSetSumMemoization(number.tail, sum) || subSetSumMemoization(number.tail, sum - number.head)
        table(number.size)(sum)
      }
    }
  }

  //********************  Top Down solution ********************************

  def subSetSumTopDown(number: Array[Int], sum: Int): Boolean = {

    //  Initialization
    table = (0 to number.size).map(i => (0 to sum).map(j => {
      if (j == 0) true
      //      else if (i == 0) false
      else false
    }).toArray).toArray

    //  Choice diagram
    (1 to number.size).map(
      i => (1 to sum).map(
        j => {
          //  If Not possible to add
          if (number(i-1) > sum) table(i)(j) = table(i - 1)(j)
          //  If possible to add, store the max
          else table(i)(j) = table(i - 1)(j) || table(i)(j - number(i - 1))
        })
    )
    table(number.size)(sum)
  }

  //********************  Driver Code **************************************
  def main(args: Array[String]): Unit = {
    val numbers: Array[Int] = Array(1, 2, 3, 7, 8, 10)
    val sum = 11

    //  Recursive
    println(subSetSum(numbers, sum))

    //  Memoization
    table = Array.fill[Boolean](numbers.size + 1, sum + 1)(false)
    println(subSetSumMemoization(numbers, sum))

    //  Top Down
    println(subSetSumTopDown(numbers,sum))
  }
}
