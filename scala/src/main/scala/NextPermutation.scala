object NextPermutation {
  def main(args: Array[String]): Unit = {
    // val newValue = Array(1, 2, 3)
    val newValue = Array(1, 5, 8, 4, 7, 6, 5, 3, 1)
    nextPermutation(newValue)
    println(newValue.toList)
  }

  def nextPermutation(nums: Array[Int]) {
    var i = nums.length - 2
    while (i >= 0 && nums(i + 1) <= nums(i)) {
      i -= 1
    }

    if (i >= 0) {
      var j = nums.length - 1
      while (nums(j) <= nums(i)) {
        j -= 1
      }
      swap(nums, i, j)
    }

    reverse(nums, i + 1)
  }

  def reverse(nums: Array[Int], start: Int) {
    var i = start
    var j = nums.length - 1

    while (i < j) {
      swap(nums, i, j)
      i += 1
      j -= 1
    }
  }

  def swap(nums: Array[Int], i: Int, j: Int) {
    val tmp = nums(i)
    nums(i) = nums(j)
    nums(j) = tmp
  }
}
