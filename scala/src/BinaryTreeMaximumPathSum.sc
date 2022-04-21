case class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  var maxValue = 0

  def maxPathSum(root: TreeNode) = {
    maxValue = Integer.MIN_VALUE
    maxPathDown(root)
    maxValue
  }

  def maxPathDown(node: TreeNode): Int = {
    if (node == null) {
      0
    } else {
      val left = Math.max(0, maxPathDown(node.left))
      val right = Math.max(0, maxPathDown(node.right))
      maxValue = Math.max(maxValue, left + right + node.value)
      node.value + Math.max(left, right)
    }
  }
}

val nine = TreeNode(9)
val fifteen = TreeNode(15)
val seven = TreeNode(7)
val twenty = TreeNode(20, fifteen, seven)
val minusTen = TreeNode(-10, nine, twenty)

Solution.maxPathSum(minusTen)
