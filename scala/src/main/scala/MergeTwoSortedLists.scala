object MergeTwoSortedLists {
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }
  def main(args: Array[String]): Unit = {
    val a = new ListNode(4)
    val b = new ListNode(2, a)
    val c = new ListNode(1, b)

    val d = new ListNode(4)
    val e = new ListNode(3, d)
    val f = new ListNode(1, e)

    show(mergeTwoLists(c, f))
  }

  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    var prehead = new ListNode(-1)
    var prev = prehead
    var cur1 = list1
    var cur2 = list2

    while (cur1 != null && cur2 != null) {
      if (cur1.x <= cur2.x) {
        prev.next = cur1
        cur1 = cur1.next
      } else {
        prev.next = cur2
        cur2 = cur2.next
      }
      prev = prev.next
    }

    prev.next = if (cur1 == null) cur2 else cur1

    prehead.next
  }

  def show(l: ListNode) {
    var arr = collection.mutable.ArrayBuffer[Int]()
    var curr = l

    while (curr != null) {
      arr += curr.x
      curr = curr.next
    }

    println(arr.toList)
  }
}
