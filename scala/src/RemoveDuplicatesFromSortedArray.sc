object Solution {
    def removeDuplicates(nums: Array[Int]): Int = {
        var lastIndex = 0

        for (i <- (1 until nums.length)) {
//            println(s"nums: ${nums.toList}")
//            println(s"lastIndex: ${lastIndex}")
//            println(s"i: ${i}")
//            println(s"nums(lastIndex): ${nums(lastIndex)}")
//            println(s"nums(i): ${nums(i)}")

            if (nums(lastIndex) < nums(i)) {
                lastIndex += 1
                nums(lastIndex) = nums(i)
            }
        }

        lastIndex + 1
    }
}

val nums = Array(1, 1, 2)
FindSubtree.removeDuplicates(nums)
println(nums.toList)
