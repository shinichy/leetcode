class Solution {
  func permute(_ nums: [Int]) -> [[Int]] {
    if nums.count == 1 {
      return [[nums[0]]]
    }

    return nums.indices.flatMap { i -> [[Int]] in
      var nums2 = nums
      nums2.remove(at: i)
      return permute(nums2).map { [nums[i]] + $0 }
    }
  }
}

print(Solution().permute([1,2,3]))
