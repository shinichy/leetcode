object BalancedBinaryTree {
  case class TreeNode(
      var value: Int = 0,
      var left: TreeNode = null,
      var right: TreeNode = null
  )

  def main(args: Array[String]): Unit = {
    // val n9 = TreeNode(9)
    // val n15 = TreeNode(15)
    // val n7 = TreeNode(7)
    // val n20 = TreeNode(20, n15, n7)
    // val n3 = TreeNode(3, n9, n20)

    // println(isBalanced(n3))
    val n4_1 = TreeNode(4)
    val n4_2 = TreeNode(4)
    val n3_1 = TreeNode(3, n4_1, n4_2)
    val n3_2 = TreeNode(3)
    val n2_1 = TreeNode(2, n3_1, n3_2)
    val n2_2 = TreeNode(2)
    val n1 = TreeNode(1, n2_1, n2_2)
    println(isBalanced(n1))
  }

  def isBalanced(root: TreeNode): Boolean = {
    isBalancedTreeHelper(root).balanced;
  }

  def isBalancedTreeHelper(root: TreeNode): TreeInfo = {
    if (root == null) {
      return TreeInfo(-1, true)
    }

    val left = isBalancedTreeHelper(root.left)
    if (!left.balanced) {
      return TreeInfo(-1, false)
    }

    val right = isBalancedTreeHelper(root.right)
    if (!right.balanced) {
      return TreeInfo(-1, false)
    }

    if (Math.abs(left.height - right.height) < 2) {
      return TreeInfo(Math.max(left.height, right.height) + 1, true)
    }

    TreeInfo(-1, false)
  }

  case class TreeInfo(height: Int, balanced: Boolean)
}
