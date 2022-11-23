public class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    public init() { self.val = 0; self.left = nil; self.right = nil; }
    public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
    public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
        self.val = val
        self.left = left
        self.right = right
    }
}
 
class Solution {
    var prev:Int?

    func isValidBST(_ root: TreeNode?) -> Bool {
      return inorder(root)
    }

    func inorder(_ root: TreeNode?) -> Bool {
        guard let root = root else {
          return true
        }

        guard inorder(root.left) else {
          return false
        }

        if let prev = prev, root.val <= prev {
          return false
        }

        prev = root.val
        return inorder(root.right)
    }
}

let n3 = TreeNode(3)
let n7 = TreeNode(7)
let n6 = TreeNode(6, n3, n7)
let n4 = TreeNode(4)
let n5 = TreeNode(5, n4, n6)
print(Solution().isValidBST(n5))

// let n1 = TreeNode(1)
// let n3 = TreeNode(3)
// let n2 = TreeNode(2, n1, n3)
// print(Solution().isValidBST(n2))

// let n2_1 = TreeNode(2)
// let n2_2 = TreeNode(2)
// let n2_3 = TreeNode(2, n2_1, n2_2)
// print(Solution().isValidBST(n2_3))
