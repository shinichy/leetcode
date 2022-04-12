import scala.util.Random

class Solution(_nums: Array[Int]) {
  def reset(): Array[Int] = {
    _nums
  }

  def shuffle(): Array[Int] = {
    Random.shuffle(_nums).toArray
  }
}


//Your Solution object will be instantiated and called as such:
val nums = Array(1, 2, 3)
var obj = new Solution(nums)
var param_1 = obj.reset()
var param_2 = obj.shuffle()

