package LinkedList

import scala.annotation.tailrec

object LinkedListRecursion {
  //  Structure of the Singly Linked List
  class Node(var data: Int, var next: Node) {
    override def toString: String = data.toString
  }

  //  Head node
  var head: Node = null

  def displayList(head: Node): Unit = {
    @tailrec
    def inner(temp: Node): Unit = {
      if (temp == null) {
        print("Null\n")
      } else if (temp.next == head) {
        print(temp.data + " -> " + head.data)
      }
      else {
        print(temp.data + " -> ")
        inner(temp.next)
      }
    }
    inner(head)
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
      else if (temp != null && temp.data == key) { //  Element found in other position
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

  def makeCircular(head: Node): Node = {
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

  def findNthElement(head: Node, n: Int): Node = {
    def inner(temp: Node, n: Int, counter: Int): Node = {
      if (temp == null) null
      else if (n - 1 == counter) return temp
      else inner(temp.next, n, counter + 1)
    }

    inner(head, n, 0)
  }

  def findNthElementFromLast(head: Node, n: Int): Node = {
    def inner(temp: Node, n: Int, target: Node): Node = {
      if (temp == null) target
      else if (n == 0 && temp == null) target
      else if (n == 0 && temp.next != null) inner(temp.next, n - 1, target.next)
      else inner(temp.next, n - 1, temp.next)
    }

    inner(head, n, null)
  }

  def length(head: Node): Int = {
    def inner(temp: Node, count: Int): Int = {
      if (temp == null) count
      else if (temp.next == null || temp.next == head) count + 1
      else inner(temp.next, count + 1)
    }

    inner(head, 0)
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
    println("7 = Make the list Circular")
    println("8 = Find nth element from the beginning")
    println("9 = Find nth element from the last")
    println("10 = Length of the list ")
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
        case 7 => makeCircular(head)
        case 8 => println(findNthElement(head, scala.io.StdIn.readInt()))
        case 9 => println(findNthElementFromLast(head, scala.io.StdIn.readInt()))
        case 10 => println(length(head))
        case _ => println("Invalid Option. \nPlease Try again\n ")
      }
    }
  }

  def main(args: Array[String]) = {
    runLinkedList()
  }
}
