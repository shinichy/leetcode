object Solution {
  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2,7,11,15), 9).toList)
    println(twoSum(Array(3,2,4), 6).toList)
    println(twoSum(Array(3,3), 6).toList)
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = collection.mutable.Map[Int,Int]()

    for {
        i <- nums.indices
    } {
        val complement = target - nums(i)
        if (map.contains(complement)) {
            return Array(i, map(complement))
        }
        map += (nums(i) -> i)
    }

    Array[Int]()
  }
}
