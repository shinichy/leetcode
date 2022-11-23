class MinStack {
    var stack: [(Int, Int)] = []

    init() {}

    func push(_ val: Int) {
        var newMin = val
        if let (_, currentMin) = stack.last,
           val > currentMin
        {
            newMin = currentMin
        }
        stack.append((val, newMin))
    }

    func pop() {
        stack.removeLast()
    }

    func top() -> Int {
        stack.last!.0
    }

    func getMin() -> Int {
        stack.last!.1
    }
}

let obj = MinStack()
obj.push(-1)
print(obj.top())
print(obj.getMin())
