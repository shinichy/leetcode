struct IntStack {
  var items = [Int]()

  mutating func push(_ item: Int) {
    items.append(item)
  }
  mutating func pop() -> Int {
    return items.removeLast()
  }
  func peek() -> Int? {
    return items.last
  }
  mutating func count() -> Int {
    return items.count
  }
  func isEmpty() -> Bool {
    return items.isEmpty
  }
  mutating func show() {
    print(items)
  }
}

class MyQueue {
  var s1 = IntStack()
  var s2 = IntStack()
  var front: Int?

  init() {

  }

  private func move() {
    while !s1.isEmpty() {
      s2.push(s1.pop())
    }
  }

  func push(_ x: Int) {
    if s1.isEmpty() {
      front = x
    }
    s1.push(x)
  }

  func pop() -> Int {
    if s2.isEmpty() {
      move()
    }
    return s2.pop()
  }

  func peek() -> Int {
    if !s2.isEmpty() {
      return s2.peek()!
    }
    return front!
  }

  func empty() -> Bool {
    return s1.isEmpty() && s2.isEmpty()
  }
}

/// Your MyQueue object will be instantiated and called as such:
/// let obj = MyQueue()
/// obj.push(x)
/// let ret_2: Int = obj.pop()
/// let ret_3: Int = obj.peek()
/// let ret_4: Bool = obj.empty()

let obj = MyQueue()
obj.push(1)
obj.push(2)
let ret_2: Int = obj.peek()
let ret_3: Int = obj.pop()
let ret_4: Bool = obj.empty()
print("ret_2: \(ret_2), ret_3: \(ret_3), ret_4: \(ret_4)")
