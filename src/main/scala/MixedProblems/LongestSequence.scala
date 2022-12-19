package MixedProblems

import scala.annotation.tailrec

object LongestSequence extends App {

  case class LongestSequenceInfo(element: Option[Int], frequence: Option[Int])

  //  My way
  def longestConsecutiveSequence(list: List[Int]): LongestSequenceInfo = {
    @tailrec
    def inner(list: List[Int], currentElement: Option[Int], currentFrequency: Option[Int], maxElement: Option[Int], maxFrequency: Option[Int]): LongestSequenceInfo = {
      if (list.isEmpty) LongestSequenceInfo(maxElement, maxFrequency)
      else {
        val element = list.head
        if (currentElement == None) inner(list.tail, Some(element), Some(1), Some(element), Some(1))
        else {
          if (element == currentElement.get) {
            if (currentFrequency.get + 1 > maxFrequency.get) inner(list.tail, currentElement, Some(currentFrequency.get + 1), currentElement, Some(currentFrequency.get + 1))
            else inner(list.tail, currentElement, Some(currentFrequency.get + 1), maxElement, maxFrequency)
          }
          else inner(list.tail, Some(element), Some(1), maxElement, maxFrequency)
        }
      }
    }

    inner(list, None, None, None, None)
  }

  val list: List[Int] = List(1, 2, 2, 3, 3, 3, 3, 4, 4, 5)
  val ans: LongestSequenceInfo = longestConsecutiveSequence(list)
  println("\nElement = " + ans.element + "\nFrequency = " + ans.frequence)



  //  Updated with for comprehension
  def longestConsecutiveSequence_v2(list: List[Int]): LongestSequenceInfo = {
    def inner(list: List[Int], currentElement: Option[Int], currentFrequency: Option[Int], maxElement: Option[Int], maxFrequency: Option[Int]): LongestSequenceInfo = {
      if (list.isEmpty) LongestSequenceInfo(maxElement, maxFrequency)
      else {
        val element = list.head
        if (currentElement == None) inner(list.tail, Some(element), Some(1), Some(element), Some(1))
        else {
          if (currentElement.contains(element)) {
            val result = for {
              freq <- currentFrequency
              maxFreq <- maxFrequency
            } yield {
              if (freq + 1 > maxFreq) inner(list.tail, currentElement, currentFrequency.map(_ + 1), currentElement, Some(freq + 1))
              else inner(list.tail, currentElement, Some(freq + 1), maxElement, maxFrequency)
            }
            result.get
          } else {
            inner(list.tail, Some(element), Some(1), maxElement, maxFrequency)
          }
        }
      }
    }

    inner(list, None, None, None, None)
  }

  val ans2: LongestSequenceInfo = longestConsecutiveSequence_v2(list)
  println("\nElement = " + ans2.element + "\nFrequency = " + ans2.frequence)


  //  Using Higher Order Function
  //  My way
  val temp = list.groupBy(x => x).maxBy(x => x._2.size)
  val ans3 = LongestSequenceInfo(Some(temp._1), Some(temp._2.size))
  println("\nElement = " + ans3.element + "\nFrequency = " + ans3.frequence)

  //  Updated way
  val (elem, coll) = list.groupBy(identity).maxBy(_._2.length)
  val ans4 = LongestSequenceInfo(Some(elem), Some(coll.length))
  println("\nElement = " + ans4.element + "\nFrequency = " + ans4.frequence)

  //  In One Line
  println(list.groupBy(identity).maxBy(_._2.length))

}
