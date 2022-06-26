case class TreeNode(
    var value: Int,
    var left: TreeNode = null,
    var right: TreeNode = null
)

object LowestCommonAncestorofaBinarySearchTree {
  def main(args: Array[String]): Unit = {
    val n0 = TreeNode(0)
    val n3 = TreeNode(3)
    val n5 = TreeNode(5)
    val n4 = TreeNode(4, n3, n5)
    val n2 = TreeNode(2, n0, n4)
    val n7 = TreeNode(7)
    val n9 = TreeNode(9)
    val n8 = TreeNode(8, n7, n9)
    val n6 = TreeNode(6, n2, n8)
    // println(dfs(n6, Nil, 5))
    println(lowestCommonAncestor(n6, n2, n8))
    println(lowestCommonAncestor(n6, n2, n4))
  }

  def lowestCommonAncestor(
      root: TreeNode,
      p: TreeNode,
      q: TreeNode
  ): TreeNode = {
    var node = root

    while (node != null) {
      if (p.value < node.value && q.value < node.value) {
        node = node.left
      } else if (p.value > node.value && q.value > node.value) {
        node = node.right
      } else {
        return node
      }
    }

    null
  }

  def dfs(
      root: TreeNode,
      vals: Array[TreeNode],
      target: Int
  ): Array[TreeNode] = {
    if (root == null) {
      return Array[TreeNode]()
    }

    if (root.value == target) {
      return vals :+ root
    }

    val leftVals = dfs(root.left, vals :+ root, target)
    if (leftVals.isEmpty) {
      dfs(root.right, vals :+ root, target)
    } else {
      leftVals
    }
  }
}
