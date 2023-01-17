package Tree

import scala.collection.mutable.ArrayBuffer

object BinaryTree {

  class Node(var data: Int, var left: Node, var right: Node)

  class BinaryTree {
    var index: Int = -1

    def buildTree(nodes: Array[Int]): Node = {
      index += 1
      if (nodes(index) == -1) null
      else {
        var newNode: Node = new Node(nodes(index), null, null)
        newNode.left = buildTree(nodes)
        newNode.right = buildTree(nodes)
        newNode
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

    def inorder(root: Node): Unit = {
      if (root == null) null
      else {
        inorder(root.left)
        print(root.data + " ")
        inorder(root.right)
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

    def countOfNodes(root: Node): Int = {
      if (root == null) 0
      else {
        val leftSubtreeCount = countOfNodes(root.left)
        val rightSubtreeCount = countOfNodes(root.right)
        leftSubtreeCount + rightSubtreeCount + 1
      }
    }

    def sumOfNodes(root: Node): Int = {
      if (root == null) 0
      else {
        val leftSubTreeSum = sumOfNodes(root.left)
        val rightSubTreeSum = sumOfNodes(root.right)
        leftSubTreeSum + rightSubTreeSum + root.data
      }
    }

    def heightOfTree(root: Node): Int = {
      if (root == null) 0
      else {
        val leftSubTreeHeight = heightOfTree(root.left)
        val rightSubTreeHeight = heightOfTree(root.right)
        if (leftSubTreeHeight > rightSubTreeHeight) leftSubTreeHeight + 1
        else rightSubTreeHeight + 1
      }
    }

    def printLeafNodes(root: Node): Unit = {
      if (root == null) null
      else if (root.left == null && root.right == null) {
        print(root.data + " ")
      }
      else {
        printLeafNodes(root.left)
        printLeafNodes(root.right)
      }
    }

    def printRoot2Leaf(root: Node): Unit = {
      def inner(root: Node, path: ArrayBuffer[Int]): Unit = {
        if (root == null) null
        else {
          //  Add the node to the path
          path.addOne(root.data)

          //  If reached a leaf
          if (root.left == null && root.right == null) {
            path.foreach(x => print(x + "->"))
            println("null")
          }
          else {
            inner(root.left, path)
            inner(root.right, path)
          }

          //  Remove the node from the path ( help in backtracking)
          path.remove(path.size-1)
        }
      }

      inner(root, new ArrayBuffer[Int]())
    }
  }

  def main(args: Array[String]): Unit = {

    val nodes: Array[Int] = Array(1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, 7, -1, -1)

    val binaryTree = new BinaryTree

    var root = binaryTree.buildTree(nodes)

    println("Data in the array = ")
    println(nodes.mkString(" "))

    println("\nPreorder Traversal")
    binaryTree.preorder(root)

    println("\nInorder Traversal")
    binaryTree.inorder(root)

    println("\nPostorder Traversal")
    binaryTree.postorder(root)

    println("\nCount of Nodes = " + binaryTree.countOfNodes(root))

    println("\nSum of Nodes = " + binaryTree.sumOfNodes(root))

    println("\nHeight of the tree = " + binaryTree.heightOfTree(root))

    println("\nLeaves of the tree")
    binaryTree.printLeafNodes(root)

    println("\nAll Root to Leaf Paths")
    binaryTree.printRoot2Leaf(root)

  }
}
