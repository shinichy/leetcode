public class ListNode {
  public var val: Int
  public var next: ListNode?
  public init(_ val: Int) {
    self.val = val
    self.next = nil
  }
}

extension ListNode: Hashable {

    public func hash(into hasher: inout Hasher) {
         hasher.combine(ObjectIdentifier(self))
    }
    
    // `hashValue` is deprecated starting Swift 4.2, but if you use 
    // earlier versions, then just override `hashValue`.
    //
    // public var hashValue: Int {
    //    return ObjectIdentifier(self).hashValue
    // }
}

extension ListNode: Equatable {

    public static func ==(lhs: ListNode, rhs: ListNode) -> Bool {
        return ObjectIdentifier(lhs) == ObjectIdentifier(rhs)
    }
}

class Solution {
  func hasCycle(_ head: ListNode?) -> Bool {
    var cur = head
    var visited = Set<ListNode>()

    while (cur != nil) {
      if visited.contains(cur!) {
        return true
      }

      visited.insert(cur!)
      cur = cur!.next
    }

    return false
  }
}

let n3 = ListNode(3)
let n2 = ListNode(2)
let n0 = ListNode(0)
let n_4 = ListNode(-4)

n3.next = n2
n2.next = n0
n0.next = n_4
n_4.next = n2

print(Solution().hasCycle(n2))
