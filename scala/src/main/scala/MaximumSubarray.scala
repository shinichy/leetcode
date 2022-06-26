object MaximumSubarray {
  def main(args: Array[String]): Unit = {
    println(maxSubArray(Array(-2,1,-3,4,-1,2,1,-5,4)))
    println(maxSubArray(Array(1)))
    println(maxSubArray(Array(5,4,-1,7,8)))
  }

  def maxSubArray(nums: Array[Int]): Int = {
    var current = nums(0)
    var max = nums(0)

    for {
      x <- nums.drop(1)
    } {
      current = Math.max(x, current+x)
      max = Math.max(max, current)
    }

    max
  }
}
