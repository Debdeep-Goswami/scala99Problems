package MixedProblems

import scala.annotation.tailrec

object LinkedListRecursion {
  //  Structure of the Singly Linked List
  class Node(var data: Int, var next: Node) {
    override def toString: String = data.toString
  }

  //  Head node
  var head: Node = null

  @tailrec
  def displayList(head: Node): Unit = {
    if (head == null) {
      print("Null\n")
    } else {
      print(head.data + " -> ")
      displayList(head.next)
    }
  }

  def addNode(head: Node, data: Int): Node = {
    @tailrec
    def inner(head: Node, current: Node, data: Int): Node = {
      if (head == null) new Node(data, null)
      else if (current.next == null) {
        current.next = new Node(data, null)
        head
      }
      else inner(head, current.next, data)
    }

    inner(head, head, data)
  }

  def deleteNode(head: Node, key: Int): Node = {
    def inner(head: Node, prev: Node, temp: Node, key: Int): Node = {
      if (head == null) {
        println("List is Empty. Nothing to delete")
        head
      }
      else if (head.data == key) head.next //  If data present at head node
      else if (temp != null && temp.data != key) inner(head, temp, temp.next, key) //  Scroll the list for the element
      else if (temp == null) head //  If node not present in the list
      else { //  If Node is found
        prev.next = temp.next //  Unlink the node from the list
        head
      }
    }

    inner(head, null, head, key)
  }

  def deleteAllOccurrences(head: Node, key: Int): Node = {
    def inner(head: Node, prev: Node, temp: Node): Node = {
      if (head == null) {
        println("List is Empty. Nothing to delete")
        head
      }
      else if (head.data == key) inner(head.next, head.next, head.next) //  If element found in head position
      else if (temp != null && temp.data == key) {  //  Element found in other position
        prev.next = temp.next
        inner(head, prev, temp.next)
      }
      else if (temp != null && temp.next != null) {
        if (temp.next.data == key) {
          temp.next = temp.next.next //  Element found in other position
          inner(head, temp, temp.next)
        }
        else inner(head, temp.next, temp.next.next) //  Scroll the list
      }
      else head
    }

    inner(head, head, head)
  }

  def findMidElement(head: Node): Node = {
    @tailrec
    def inner(head: Node, slow: Node, fast: Node): Node = {
      if (head == null) head
      else {
        if (fast != null && fast.next != null) inner(head, slow.next, fast.next.next)
        else slow
      }
    }

    inner(head, head, head)
  }

  def detectLoop(head: Node): Boolean = {
    @tailrec
    def inner(head: Node, slow: Node, fast: Node): Boolean = {
      if (head == null) false
      else if (fast != null && fast.next != null) {
        if (slow == fast) true
        else inner(head, slow.next, fast.next.next)
      }
      else false
    }

    inner(head, head, head)
  }

  def makeCircullar(head: Node): Node = {
    @tailrec
    def inner(head: Node, temp: Node): Node = {
      if (head == null) {
        println("List is empty")
        head
      }
      else if (temp.next != null) inner(head, temp.next)
      else {
        temp.next = head
        head
      }
    }

    inner(head, head)
  }

  def showOptions(): Int = {
    println("\n__________________________________\n")
    println("Select one of the option")
    println("0 = Exit")
    println("1 = Display")
    println("2 = Add at the last")
    println("3 = Delete One")
    println("4 = Delete All Occurrences")
    println("5 = Find Mid")
    println("6 = Detect Loop")
    println("7 = Make the list Circullar")
    print("Enter choice = ")
    scala.io.StdIn.readInt()
  }

  def runLinkedList(): Unit = {
    var loopThrough = true
    while (loopThrough) {
      var option = showOptions()
      option match {
        case 0 => loopThrough = false
        case 1 => displayList(head)
        case 2 => head = addNode(head, scala.io.StdIn.readInt())
        case 3 => head = deleteNode(head, scala.io.StdIn.readInt())
        case 4 => head = deleteAllOccurrences(head, scala.io.StdIn.readInt())
        case 5 => println(findMidElement(head))
        case 6 => println(detectLoop(head))
        case 7 => makeCircullar(head)
        case _ => println("Invalid Option. \nPlease Try again\n ")
      }
    }
  }

  def main(args: Array[String]) = {
    runLinkedList()
  }
}
