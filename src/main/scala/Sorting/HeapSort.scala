package Sorting

import scala.annotation.tailrec

object HeapSort {

  /*  Algorithm

  Step 1 Create a Heap from the given array (Skip the leaf nodes as they are already in heap)
  Step 2 Delete root node (Swap the root node with last element of the current array)
  Step 3 Heapify the current array
  Step 4 Repeat Step 2 and Step 3 for every element in the array

   */
  def heapSort(array: Array[Int]): Unit = {

    var heapSize = array.length - 1

    //  Step 1 Build Heap for all internal nodes
    buildHeap(array)

    //  Step 4 - Using Loop
    //    while (heapSize > 0) {
    //      swap(array, 0, heapSize)
    //      heapSize -= 1
    //      heapify(array, 0, heapSize)
    //    }

    //  Step 4 - Using HF
    (heapSize to 1 by -1).map(x => {
      //  Step 2 Delete Root node
      swap(array, 0, x)

      //  Step 3 Heapify the current array
      heapify(array, 0, x)
    })
  }

  def buildHeap(array: Array[Int]): Unit = {
    val heapSize = array.length

    //  Using loop
    //    for (i <- heapSize / 2 to 0 by -1) heapify(array, i, heapSize)

    //  Using HF
    (heapSize / 2 to 0 by -1).map(i => heapify(array, i, heapSize))
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
