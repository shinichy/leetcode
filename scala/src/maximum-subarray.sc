object Solution {
  def maxSubArray(nums: Array[Int]): Int = {
    var currentSubarray = nums(0)
    var maxSubarray = nums(0)

    for (i <- (1 until nums.length)) {
      val num = nums(i)
      currentSubarray = Math.max(num, currentSubarray + num)
      maxSubarray = Math.max(maxSubarray, currentSubarray)
    }

    maxSubarray
  }
}

// State
// largest sum so far
// current largest sum

// Logic
// i : from 0 to nums.length - 1
// If nums(i)
// Find the largest sum

//val nums = Array(-2,1,-3,4,-1,2,1,-5,4)
//val nums = Array(1)
val nums = Array(5, 4, -1, 7, 8, -1, 2)

FindSubtree.maxSubArray(nums)
