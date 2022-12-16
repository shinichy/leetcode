class Solution {
  var memo = [[Int]:Bool]()

    func canPartition(_ nums: [Int]) -> Bool {
      let sum = nums.reduce(0, +)
      if sum%2 != 0 {
        return false
      }
      let subsetSum = sum/2
      return dfs(nums, nums.count-1,subsetSum)
    }

    func dfs(_ nums: [Int], _ n: Int, _ subsetSum: Int) -> Bool {
      if subsetSum == 0 {
        return true
      }

      if n == 0 || subsetSum < 0 {
        return false
      }

      if let res = memo[[n,subsetSum]] {
        return res
      }
      
      let res = dfs(nums, n-1, subsetSum) || dfs(nums,n-1, subsetSum-nums[n])
      memo[[n,subsetSum]] = res

      return res
    }
}

// print(Solution().canPartition([1,5,5,11]))
print(Solution().canPartition([1,1]))
