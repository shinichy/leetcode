object Solution {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var i2, i3 = 0
    val nums3 = new Array[Int](m)
    Array.copy(nums1, 0, nums3, 0, m)

    for (i <- (0 until nums1.length)) {
      if (i3 < nums3.length && i2 < nums2.length) {
        if (nums3(i3) < nums2(i2)) {
          nums1(i) = nums3(i3)
          i3 += 1
        } else {
          nums1(i) = nums2(i2)
          i2 += 1
        }
      } else if (i3 < nums3.length) {
        nums1(i) = nums3(i3)
        i3 += 1
      } else {
        nums1(i) = nums2(i2)
        i2 += 1
      }
    }
  }
}

// State
// current index for nums1 and nums2
// current value for nums1 for comparison

// Logic
// If value is less than nums2(i2),
// assign value to nums1(i1)
// i1 += 1
// value = nums1(i1)
// Else
// assign nums2(i2) to nums1(i1)
// i1 += 1
// i2 += 1

val nums1 = Array(1,2,3,0,0,0)
val nums2 = Array(2,5,6)

FindSubtree.merge(nums1, nums1.length - nums2.length, nums2, nums2.length)
println(nums1.toList)
