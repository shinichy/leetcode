func randomFruit(_ fruites: [String: Double]) -> String {
  var prefixSums = [Double](repeating: 0.0, count: fruites.count)
  let keys: [String] = fruites.keys.map { $0 }
  print("keys: \(keys)")
  prefixSums[0] = fruites[keys[0]]!
  // pre calculate
  for i in 1 ..< keys.count {
    prefixSums[i] = prefixSums[i - 1] + fruites[keys[i]]!
  }

  print("prefixSums: \(prefixSums)")
  let randomWeight = Double.random(in: 0 ..< prefixSums[prefixSums.count - 1])
  print("randomWeight: \(randomWeight)")
  // Get the index of min value greater than random weight
  let index = bs(prefixSums, randomWeight)
  print("index: \(index)")

  return keys[index]
}

func bs(_ sums: [Double], _ target: Double) -> Int {
  var left = 0
  var right = sums.count - 1

  while left < right {
    let mid:Int = (left + right) / 2
    // print("left:\(left), right:\(right), mid:\(mid)")
    if sums[mid] <= target {
      // search right
      left = mid + 1
    } else {
      // search left
      right = mid
    }
  }

  if right < 0 {
    return -1
  }

  return right
}

let a = [Int]()
a[0]
print(randomFruit(["apple": 2.5, "orange": 1.5, "kiwi": 4.0, "banana": 2.0]))

// print(bs([2.5, 4.0, 8.0, 10.0], 1.0))
// print(bs([2.5, 4.0, 8.0, 10.0], 2.6))
// print(bs([2.5, 4.0, 8.0, 10.0], 5.0))
// print(bs([2.5, 4.0, 8.0, 10.0], 9.0))
