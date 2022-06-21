/** Definition for singly-linked list. class ListNode(_x: Int = 0, _next:
  * ListNode = null) { var next: ListNode = _next var x: Int = _x }
  */


object AddTwoNumbers {
class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
  def main(args: Array[String]): Unit = {
    val l1 = toNodes(List(2, 4, 3))
    val l2 = toNodes(List(5, 6, 4))
    show(addTwoNumbers(l1, l2))

    val l3 = toNodes(List(0))
    val l4 = toNodes(List(0))
    show(addTwoNumbers(l3, l4))

    val l5 = toNodes(List(9,9,9,9,9,9,9))
    val l6 = toNodes(List(9,9,9,9))
    show(addTwoNumbers(l5, l6))
  }

  def toNodes(list: List[Int]): ListNode = {
    var head: ListNode = new ListNode(0)
    var tail: ListNode = head

    for {
      v <- list
    } {
      val newNode = new ListNode(v)
      tail.next = newNode
      tail = newNode
    }

    head.next
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

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var carry = 0
    var head: ListNode = new ListNode(0)
    var tail: ListNode = head
    var curr1 = l1
    var curr2 = l2

    while (curr1 != null || curr2 != null) {
      val val1 = if (curr1 == null) 0 else curr1.x
      val val2 = if (curr2 == null) 0 else curr2.x
      val sum = val1 + val2 + carry
      val (newVal, newCarry) = if (10 <= sum) {
        (sum - 10, 1)
      } else {
        (sum, 0)
      }
      carry = newCarry
      val newNode = new ListNode(newVal)
      tail.next = newNode
      tail = newNode
      if (curr1 != null) {
        curr1 = curr1.next
      }
      if (curr2 != null) {
        curr2 = curr2.next
      }
    }

    if (0 < carry) {
      val newNode = new ListNode(carry)
      tail.next = newNode
      tail = newNode
    }

    head.next
  }
}
