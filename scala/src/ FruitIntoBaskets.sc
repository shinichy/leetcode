object Solution {
  def totalFruit(fruits: Array[Int]): Int = {
    var res = 0
    var cur = 0
    var count_b = 0
    var a = 0
    var b = 0

    for (c <- fruits) {
//      println(s"c: $c")

      cur = if (c == a || c == b) {
        cur + 1
      } else {
        count_b + 1
      }

      count_b = if (c == b) {
        count_b + 1
      } else {
        1
      }

      if (b != c) {
        a = b
        b = c
      }

      res = Math.max(res, cur)
//      println(s"a: $a, b: $b, cur: $cur, count_b: $count_b, res: $res")
    }

    res
  }
}

// Group fruits by same consecutive numbers
// e.g. groupedFruits: [[1],[2,2],[3],[2,2],[5,5,5,5,5]]
// For each i from 0 until groupedFruits.length
// Put as many groupedFruits as possible from i + 1
// Calculate max and update max so far

val fruits = Array(1, 2, 2, 3, 2, 2, 5, 5, 5, 5, 5)
//val fruits = Array(1,2,1)
//val fruits = Array(0,1,2,2)
//val fruits = Array(0)
val groupedFruits = Solution.groupConsecutive(fruits.toList)

println(Solution.totalFruit(fruits))
