class Solution {
    func sortColors(_ nums: inout [Int]) {
      var s = 0
      var e = nums.count-1
      
      while s < e {
        print("s:\(s), e:\(e)")
        if s+1 == e, nums[s] == nums[e] {
          break
        }

        while nums[s] == 0 {
          s += 1
        }
        
        while nums[e] == 2 {
          e -= 1
        }
        
        print("foo s:\(s), e:\(e)")
        if nums[s] == 2 {
          nums.swapAt(s,e)
          e -= 1
        }
        
        if nums[e] == 0 {
          nums.swapAt(s,e)
          s += 1
        }

        print("bar s:\(s), e:\(e)")
      }
    }
}

// var colors = [2,0,2,1,1,0]
// var colors = [2,0,1]
// var colors = [1,0]
// var colors = [0,2]
var colors = [1,2,1]
Solution().sortColors(&colors)
print(colors)
