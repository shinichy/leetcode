object FindLeavesBinaryTree extends App {
  case class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def findLeaves(root: TreeNode): List[List[Int]] = {
    val res = collection.mutable.ArrayBuffer[collection.mutable.ListBuffer[Int]]()
    height(root, res)
    res.map(_.toList).toList
  }

  def height(node: TreeNode, res: collection.mutable.ArrayBuffer[collection.mutable.ListBuffer[Int]]): Int = {

    if (node == null) {
      -1
    } else {
      //println(s"value: ${node.value}")

      val level = 1 + Math.max(height(node.left, res), height(node.right, res))
      //println(s"level: $level")
      if (res.size < level + 1) {
        res.append(collection.mutable.ListBuffer())
      }

      res(level).append(node.value)
      level
    }
  }

  val four = TreeNode(4)
  val five = TreeNode(5)
  val two = TreeNode(2, four, five)
  val three = TreeNode(3)
  val one = TreeNode(1, two, three)

  def poTraversal(n: TreeNode): Array[Int] = {
    if (n == null) {
      Array[Int]()
    } else {
      poTraversal(n.left) ++ Array(n.value) ++ poTraversal(n.right)
    }
  }


  println(poTraversal(one).toList)
  //println(findLeaves(one))
}
