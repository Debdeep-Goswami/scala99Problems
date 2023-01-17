package LinkedList

object LinkedList {
  //  Structure of the Singly Linked List
  class Node(var data: Int, var next: Node) {
    override def toString: String = data.toString
  }

  //  Head node
  var head: Node = null

  def displayList(head: Node): Unit = {
    if (head == null) {
      println("List is Empty")
    } else {
      var temp = head
      println("The List is ")
      while (temp != null) {
        print(temp.data + " -> ")
        temp = temp.next
      }
      print("Null\n")
    }
  }

  def addNode(head: Node, data: Int): Node = {
    if (head == null) {
      var temp = new Node(data, null)
      temp
    } else {
      var temp: Node = head;
      while (temp.next != null) {
        temp = temp.next
      }
      temp.next = new Node(data, null)
      head
    }
  }

  def deleteNode(head: Node, key: Int): Node = {
    if (head == null) {
      println("List is Empty. Nothing to delete")
      head
    } else {
      var temp: Node = head
      var prev: Node = null
      //  If head node is to be deleted
      if (temp.data == key) temp.next
      else {
        //  For any node other than head
        while (temp != null && temp.data != key) {
          prev = temp
          temp = temp.next
        }
        //  if node not present in the list
        if (temp == null) head
        else {
          prev.next = temp.next
          head
        }
      }
    }
  }

  def deleteAllOccurrences(head: Node, key: Int): Node = {
    //  https://workat.tech/problem-solving/approach/roll/remove-occurences-linked-list
    if (head == null) {
      println("List is Empty. Nothing to delete")
      head
    } else {
      var newHead: Node = head
      var temp: Node = head
      //  If head node matches with key
      while (temp != null && temp.data == key) {
        temp = temp.next
        newHead = temp
      }
      temp = newHead
      while (temp != null && temp.next != null) {
        if (temp.next.data == key) temp.next = temp.next.next
        else temp = temp.next
      }
      newHead
    }
  }

  def findMidElement(head: Node): Node = {
    if (head == null) head
    else {
      var slow: Node = head
      var fast: Node = head
      while (fast != null && fast.next != null) {
        slow = slow.next
        fast = fast.next.next
      }
      slow
    }
  }

  def detectLoop(head: Node): Boolean = {
    if (head == null) false
    else {
      var slow = head
      var fast = head
      var foundLoop = false
      while (fast != null && fast.next != null && foundLoop == false) {
        slow = slow.next
        fast = fast.next.next
        if (slow == fast) foundLoop = true
      }
      foundLoop
    }
  }

  def makeCircullar(head: Node): Node = {
    if (head == null) {
      println("List is empty")
      head
    } else {
      var temp = head
      while (temp.next != null) {
        temp = temp.next
      }
      temp.next=head
      head
    }
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
