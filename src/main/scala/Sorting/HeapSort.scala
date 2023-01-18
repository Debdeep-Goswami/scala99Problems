package Sorting

import scala.annotation.tailrec

object HeapSort {
  def heapSort(array: Array[Int]): Unit = {

    var heapSize = array.length - 1
    //  Build Heap for all internal nodes
    buildHeap(array)

    //  Delete root one by one and heapify the rest of array
    while (heapSize > 0) {
      swap(array, 0, heapSize)
      heapSize -= 1
      heapify(array, 0, heapSize)
    }
  }

  def buildHeap(array: Array[Int]): Unit = {
    val heapSize = array.length
    for (i <- heapSize / 2 to 0 by -1) heapify(array, i, heapSize)
  }

  def swap(array: Array[Int], left: Int, right: Int): Unit = {
    val temp = array(left)
    array(left) = array(right)
    array(right) = temp
  }

  @tailrec
  def heapify(array: Array[Int], current: Int, size: Int): Unit = {
    //  Making root as the largest
    var largestLocation = current
    val leftChildLocation = 2 * current + 1
    val rightChildLocation = 2 * current + 2

    //  Comparing both child for the largest
    if (leftChildLocation < size && array(leftChildLocation) > array(largestLocation)) largestLocation = leftChildLocation
    if (rightChildLocation < size && array(rightChildLocation) > array(largestLocation)) largestLocation = rightChildLocation

    //  If largest is not root
    if (largestLocation != current) {
      swap(array, largestLocation, current)
      heapify(array, largestLocation, size)
    }
  }

  def main(args: Array[String]): Unit = {
//    val array = Array(10, 15, 20, 8, 16, 30, 50)
    val array = Array(10, 15, -20, -8, 16, 30, -50)
    println("Before Sorting " + array.mkString(" "))
    heapSort(array)
    println("After Sorting " + array.mkString(" "))
  }
}
