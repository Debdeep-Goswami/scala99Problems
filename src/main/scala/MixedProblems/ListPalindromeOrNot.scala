package MixedProblems

object ListPalindromeOrNot extends App {

  def isListPalindrome[T](list: List[T]) : Boolean ={
    if(list.equals(list.reverse)) true
    else false
  }

  //  Proper Input
  val list = List(1,2,3,2,1)
  println(isListPalindrome(list))

  val list2 = List(1,2,3,4,5)
  println(isListPalindrome(list2))

  //  List with One Element
  val oneElementList = List(1)
  println(isListPalindrome(oneElementList))

  //  Empty List
  val emptyList = List.empty[Int]
  println(isListPalindrome(emptyList))
}
