class Solution {
  func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
    var map = [Int: Int]()

    for i in nums.indices {
      let rest = target - nums[i]
      if let j = map[rest], j != i {
        return [i, j]
      }
      map[nums[i]] = i
    }

    return []
  }
}

print(Solution().twoSum([3, 2, 4], 6))
