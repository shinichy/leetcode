 public class TreeNode {
   public var val: Int
   public var left: TreeNode?
   public var right: TreeNode?
   public init(_ val: Int, _ left: TreeNode? = nil, _ right: TreeNode? = nil) {
     self.val = val
     self.left = left
     self.right = right
   }
 }

 class Solution {
   func lowestCommonAncestor(_ root: TreeNode?, _ p: TreeNode?, _ q: TreeNode?) -> TreeNode? {
     // Get paths for p and q (binary search)
     let pathP = binarySearch(root, p!, [])!
     let pathQ = binarySearch(root, q!, [])!

    //  print("pathP: \(vals(pathP))")
    //  print("pathQ: \(vals(pathQ))")

     // Get LCA by comparing the paths from the root
     var indexP = 0
     var indexQ = 0
     var lca = pathP[0]

     while true {
       if indexP >= pathP.count || indexQ >= pathQ.count {
         return lca
       }

       if pathP[indexP].val != pathQ[indexQ].val {
         return lca
       } else {
         lca = pathP[indexP]
        //  print("lca:\(lca.val)")
         indexP += 1
         indexQ += 1
       }
     }
   }

   func binarySearch(_ root: TreeNode?, _ target: TreeNode, _ path: [TreeNode]) -> [TreeNode]? {
     if root == nil {
       return nil
     }

     let root = root!
     if root.val == target.val {
       return path + [root]
     }

     if let result = binarySearch(root.left, target, path + [root]) {
       return result
     } else {
       return binarySearch(root.right, target, path + [root])
     }
   }

   func vals(_ nodes: [TreeNode]) -> [Int] {
     nodes.map { $0.val }
   }
 }

 let n6 = TreeNode(6)
 let n7 = TreeNode(7)
 let n4 = TreeNode(4)
 let n2 = TreeNode(2, n7, n4)
 let n5 = TreeNode(5, n6, n2)
 let n0 = TreeNode(0)
 let n8 = TreeNode(8)
 let n1 = TreeNode(1, n0, n8)
 let n3 = TreeNode(3, n5, n1)

 print(Solution().lowestCommonAncestor(n3, n5, n1)!.val)
 print(Solution().lowestCommonAncestor(n3, n5, n4)!.val)

//  let n2 = TreeNode(2)
//  let n3 = TreeNode(3)
//  let n1 = TreeNode(1, n2, n3)

//  print(Solution().lowestCommonAncestor(n1, n2, n3)!.val)
