public class ListNode {
  public var val: Int
  public var next: ListNode?
  public init() { self.val = 0; self.next = nil }
  public init(_ val: Int) { self.val = val; self.next = nil }
  public init(_ val: Int, _ next: ListNode?) { self.val = val; self.next = next }
}

class Solution {
  func mergeTwoLists(_ list1: ListNode?, _ list2: ListNode?) -> ListNode? {
    guard let list1 = list1 else {
      return list2
    }
    guard let list2 = list2 else {
      return list1
    }

    if list1.val <= list2.val {
        list1.next = mergeTwoLists(list1.next, list2)
        return list1
    } else {
        list2.next = mergeTwoLists(list1, list2.next)
        return list2
    }
  }
}

func printList(_ node: ListNode?) {
  while head != nil {
    print(head!.val)
    head = head!.next
  }
}

let n4 = ListNode(4)
let n2 = ListNode(2, n4)
let n1 = ListNode(1, n2)

let n4_2 = ListNode(4)
let n3 = ListNode(3, n4_2)
let n1_2 = ListNode(1, n3)

var head = Solution().mergeTwoLists(n1, n1_2)
printList(head)

// let n4 = ListNode(4)
// let n2 = ListNode(2, n4)
// let n1 = ListNode(1, n2)

// var head = Solution().mergeTwoLists(n1, ListNode(5))
// printList(head)
