class Solution {
  func merge(_ intervals: [[Int]]) -> [[Int]] {
    var intervals = intervals
    var result = [[Int]]()
    intervals.sort { a,b -> Bool in
      a[0] < b[0]
    }
    var interval = intervals.removeFirst()

    // print("intervals:\(intervals)")

    for it in intervals {
      if isOverlapped(interval, it) {
        interval = merge(interval, it)
      } else {
        result.append(interval)
        interval = it
      }
    }

    result.append(interval)
    return result
  }

  func isOverlapped(_ it1:[Int], _ it2:[Int]) -> Bool {
    it1[1] >= it2[0]
  }

  func merge(_ it1:[Int], _ it2:[Int]) -> [Int] {
    [min(it1[0],it2[0]), max(it1[1],it2[1])]
  }
}

// print(Solution().merge([[1,3],[2,6],[8,10],[15,18]]))
// print(Solution().merge([[1,4],[4,5]]))
// print(Solution().merge([[1,4],[0,4]]))
print(Solution().merge([[1,4],[2,3]]))
