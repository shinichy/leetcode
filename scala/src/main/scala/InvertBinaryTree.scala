object InvertBinaryTree {
  class TreeNode(
      _value: Int = 0,
      _left: TreeNode = null,
      _right: TreeNode = null
  ) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right

    override def toString() = {
      s"TreeNode(value: $value, left: $left, right: $right)"
    }
  }

  def main(args: Array[String]): Unit = {
    val n1 = new TreeNode(1)
    val n3 = new TreeNode(3)
    val n2 = new TreeNode(2, n1, n3)
    val n6 = new TreeNode(6)
    val n9 = new TreeNode(9)
    val n7 = new TreeNode(7, n6, n9)
    val n4 = new TreeNode(4, n2, n7)

    invertTree(n4)
  }

  def invertTree(root: TreeNode): TreeNode = {
    if (root == null) {
      return root
    }

    val right = invertTree(root.left)
    val left = invertTree(root.right)

    // println(s"left: $left, right: $right")

    root.left = left
    root.right = right

    // println(root)

    root
  }
}
