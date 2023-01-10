package dp

object Knapsack0_1 {

  //  Recursive Solution
  def knapsack0_1(weights: Array[Int], values: Array[Int], capacity: Int): Int = {

    //  Base case
    if (weights.isEmpty || capacity <= 0) 0

    //  Choice Diagram

    //  If Not possible to add
    else if (weights.head > capacity) knapsack0_1(weights.tail, values.tail, capacity)

    //  If Possible to add
    else knapsack0_1(weights.tail, values.tail, capacity).max(values.head + knapsack0_1(weights.tail, values.tail, capacity - weights.head))
  }


  //***********************  Memoization Solution  ***************************************

  //  DP table to store the value
  var table: Array[Array[Int]] = null

  def knapsack0_1_Memoization(weights: Array[Int], values: Array[Int], capacity: Int): Int = {

    //  Base case to terminate
    if (weights.isEmpty || capacity <= 0) 0


    //  Choice Diagram

    //  Special Case to check the DP table for existing value ( to reduce function call)
    else if (table(weights.size)(capacity) != -1) table(weights.size)(capacity)

    else if (weights.head > capacity) {
      //  If not possible to add
      table(weights.size)(capacity) = knapsack0_1_Memoization(weights.tail, values.tail, capacity)
      table(weights.size)(capacity)
    }
    else {
      //  If possible to add
      table(weights.size)(capacity) = knapsack0_1_Memoization(weights.tail, values.tail, capacity).max(values.head + knapsack0_1_Memoization(weights.tail, values.tail, capacity - weights.head))
      table(weights.size)(capacity)
    }
  }

  //**************************  Top Down Approach *************************************

  def knapsack0_1_TopDown(weights: Array[Int], values: Array[Int], capacity: Int): Int = {
    //  Initialization
    table = (0 to weights.size).map(x => (0 to capacity).map(y => if (x == 0 || y == 0) 0 else -1).toArray).toArray

    //  Choice Diagram
    (1 to weights.size).map(
      w => (1 to capacity).map(
        c => {
          if (weights(w - 1) > c) {
            //  If not possible add
            table(w)(c) = table(w - 1)(c)
          } else {
            table(w)(c) = table(w - 1)(c).max(values(w - 1) + table(w - 1)(c - weights(w - 1)))
          }
        }
      )
    )
    table(weights.size)(capacity)
  }


  //****************  Driver Code *******************************

  def main(args: Array[String]): Unit = {
    val weights: Array[Int] = Array(1, 2, 3)
    val values: Array[Int] = Array(4, 5, 5)
    val capacity = 3
    //  Normal Recursive Solution
    println(knapsack0_1(weights, values, capacity))

    //  Memoization solution
    //  Initializing the array with -1
    table = Array.fill[Int](weights.size + 1, capacity + 1)(-1)
    println(knapsack0_1_Memoization(weights, values, capacity))

    //  Top Down Solution
    println(knapsack0_1_TopDown(weights, values, capacity))
    table.map(x => println(x.mkString(" ")))
  }
}
