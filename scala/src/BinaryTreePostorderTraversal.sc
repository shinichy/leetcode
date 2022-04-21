case class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
    def postorderTraversal(root: TreeNode): List[Int] = {
      if (root == null) {
        Nil
      } else {
        postorderTraversal(root.left) ++ postorderTraversal(root.right) :+ root.value
      }
    }
}

val three = TreeNode(3)
val two = TreeNode(2, three)
val one = TreeNode(1, null, two)

Solution.postorderTraversal(one)
