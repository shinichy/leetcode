object Solution {
  val mappings = Map(
    ')' -> '(',
    '}' -> '{',
    ']' -> '[',
  )

  def isValid(s: String): Boolean = {
    val stack = collection.mutable.Stack.empty[Character]

    for (ch <- s) {
      ch match {
        case '(' | '{' | '[' => stack.push(ch)
        case _ => if (stack.isEmpty || stack.pop() != mappings(ch)) {
          return false
        }
      }
    }

    stack.isEmpty
  }
}

// State
// stack of open brackets

// Logic
// For each character
// If the bracket is open, push it to the stack
// Else, pop the open bracket from the stack and compare the type. Return false if they don't match
// True if stack is empty

FindSubtree.isValid("()")
FindSubtree.isValid("()[]{}")
FindSubtree.isValid("(]")
FindSubtree.isValid("]")
