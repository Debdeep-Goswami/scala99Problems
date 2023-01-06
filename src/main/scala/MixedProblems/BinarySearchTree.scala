package MixedProblems

import scala.collection.mutable.ArrayBuffer

object BinarySearchTree {

  class Node(var data: Int, var left: Node = null, var right: Node = null)

  class BinarySearchTree {

    def insert(root: Node, value: Int): Node = {
      if (root == null) new Node(value)
      else if (root.data > value) {
        root.left = insert(root.left, value)
        root
      }
      else {
        root.right = insert(root.right, value)
        root
      }
    }

    def inorder(root: Node): Unit = {
      if (root == null) null
      else {
        inorder(root.left)
        print(root.data + " ")
        inorder(root.right)
      }
    }

    def preorder(root: Node): Unit = {
      if (root == null) null
      else {
        print(root.data + " ")
        preorder(root.left)
        preorder(root.right)
      }
    }

    def postorder(root: Node): Unit = {
      if (root == null) null
      else {
        postorder(root.left)
        postorder(root.right)
        print(root.data + " ")
      }
    }

    def search(root: Node, key: Int): Boolean = {
      if (root == null) false
      else if (root.data == key) true
      else if (root.data > key) search(root.left, key)
      else search(root.right, key)
    }

    def delete(root: Node, key: Int): Node = {
      if (root.data > key) delete(root.left, key)
      else if (root.data < key) delete(root.right, key)
      else { //  Node found tobe deleted

        //  Case 1 (No Child)
        if (root.left == null && root.right == null) null

        //  Case 2 (One child)
        else if (root.left == null) root.right

        else if (root.right == null) root.left

        //  Case 3 (Two child)
        else {
          var iS = inorderSuccessor(root.right)
          root.data = iS.data
          root.right = delete(root.right, iS.data)
          root
        }
      }
    }

    def inorderSuccessor(root: Node): Node = {
      if (root.left == null) root
      else inorderSuccessor(root.left)
    }

    def printInRange(root: Node, start: Int, end: Int): Unit = {

      if (root == null) null

      //  If Root is bigger than the end
      else if (root.data > end) printInRange(root.left, start, end)

      //  If Root is lesser than the start
      else if (root.data < start) printInRange(root.right, start, end)

      //  Root falls between the range
      else {
        printInRange(root.left, start, end) //  Print Left subtree
        print(root.data + " ") //  Print Root
        printInRange(root.right, start, end) //  Print Right subtree
      }
    }

    def printLeafNodes(root: Node): Unit = {
      if (root == null) null
      else if (root.left == null && root.right == null) print(root.data + " ")
      else {
        printLeafNodes(root.left)
        printLeafNodes(root.right)
      }
    }

    def printRoot2Leaf(root: Node): Unit = {
      def inner(root: Node, path: ArrayBuffer[Int]): Unit = {
        if (root == null) null
        else {
          //  Adding the node to the path
          path.addOne(root.data)

          //  If node is a leaf
          if (root.left == null && root.right == null) {
            //  Print the Path
            path.foreach(x=> print(x+"->"))
            println("null")
          }

          //  Non Leaf
          else {
            inner(root.left, path)
            inner(root.right, path)
          }

          //  Remove the node from the path ( help in backtracking)
          path.remove(path.size - 1)
        }
      }
      inner(root,new ArrayBuffer[Int]())
    }
  }

  def main(args: Array[String]): Unit = {
    val nodes: Array[Int] = Array(8, 5, 3, 1, 4, 6, 10, 11, 14)


    val binarySearchTree: BinarySearchTree = new BinarySearchTree

    var root: Node = null
    //  Inserting into the BST
    nodes.map(x => {
      root = binarySearchTree.insert(root, x)
    })

    //  Inorder
    println()
    binarySearchTree.inorder(root)

    //  Preorder
    //    println()
    //    binarySearchTree.preorder(root)

    //  Postorder
    //    println()
    //    binarySearchTree.postorder(root)

    //  Search
    //    println()
    //    println(if (binarySearchTree.search(root, 7)) "Found" else "Not Found")

    //  Delete a node
    //    println()
    //    println(binarySearchTree.delete(root, 5))
    //    binarySearchTree.inorder(root)

    //  Print in Range
    //    println()
    //    binarySearchTree.printInRange(root, 3, 12)

    //  Print Leaf Nodes
    //    println()
    //    binarySearchTree.printLeafNodes(root)

    //  Print All Root to Leaf paths of the tree
    println()
    binarySearchTree.printRoot2Leaf(root)
  }
}
