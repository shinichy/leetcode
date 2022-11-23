class Solution {
  func combinationSum(_ candidates: [Int], _ target: Int) -> [[Int]] {
    var results = [[Int]]()
    var comb = [Int]()
    backtrack(target, &comb, 0, candidates, &results)
    return results
  }

  func backtrack(_ remain: Int, _ comb: inout [Int], _ start: Int, _ candidates: [Int], _ results: inout [[Int]]) {
    if remain == 0 {
      let comb2 = Array(comb)
      results.append(comb2)
      return
    } else if remain < 0 {
      return
    }

    for i in start..<candidates.count {
      comb.append(candidates[i])
      backtrack(remain - candidates[i], &comb, i, candidates, &results)
      comb.removeLast()
    }
  }
}

// print(Solution().combinationSum([2, 3, 6, 7], 7))
print(Solution().combinationSum([7, 3, 2], 18))
