//package MixedProblems
//
//object QuickSort {
//
//  def partition(array: Array[Int], low: Int, high: Int): Int = {
//    val pivot = array(high)
//
//    var lp = low
//    var rp = high
//    while (lp < rp) {
//      while (array(lp) <= pivot && lp < rp){
//
//      }
//    }
//  }
//
//  def quickSort(array: Array[Int], low: Int, high: Int): Unit = {
//    if (low > high) null
//    else {
//      val partitionIndex: Int = partition(array, low, high)
//      quickSort(array, low, partitionIndex - 1)
//      quickSort(array, partitionIndex + 1, high)
//    }
//  }
//
//}
