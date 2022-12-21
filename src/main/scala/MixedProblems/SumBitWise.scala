package MixedProblems

object SumBitWise extends App {
  def bitwiseSum(sum: Int, carry: Int): Int = {
    if (carry == 0) sum
    else {
      val newSum = sum ^ carry              //  XOR Operation for Sum
      val newCarry = (sum & carry) << 1     //  AND + Left Shift Operation for Carry
      bitwiseSum(newSum, newCarry)
    }
  }
  val x = 5
  val y = 7
  println(bitwiseSum(x, y))
}
