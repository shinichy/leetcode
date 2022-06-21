import scala.annotation.tailrec

object BinarySearch {
  def main(args: Array[String]): Unit = {
    println(search(Array(-1, 0, 3, 5, 9, 12), 9))
    println(search(Array(-1, 0, 3, 5, 9, 12), -1))
  }

  def search(nums: Array[Int], target: Int): Int = {
    binarySearch(nums, target, 0, nums.length - 1)
  }

  @tailrec
  def binarySearch(nums: Array[Int], target: Int, low: Int, high: Int): Int = {
    if (high < low) {
      return -1
    }

    val mid = low + (high - low) / 2

    if (nums(mid) == target) {
      return mid
    }

    if (nums(mid) < target) {
      binarySearch(nums, target, mid + 1, high)
    } else {
      binarySearch(nums, target, low, mid - 1)
    }
  }
}
