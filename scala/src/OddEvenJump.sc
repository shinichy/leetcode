import scala.collection.mutable

object Solution {
  def oddEvenJumps(arr: Array[Int]) = {
    val isGoodEven = new Array[Boolean](arr.length)
    val isGoodOdd = new Array[Boolean](arr.length)
    val numPos = new mutable.TreeMap[Int, Int]()
    for (i <- arr.length - 1 to 0 by -1) {
//      println(s"i: $i")
//      println(s"arr(i): ${arr(i)}")

      if (i == arr.length - 1) {
        isGoodOdd(i) = true
        isGoodEven(i) = true
      } else {
        numPos.minAfter(arr(i)).foreach { case (smallestGreater, idx) =>
//          println(s"smallestGreater: $smallestGreater, index: $idx, isGoodEven(idx): ${isGoodEven(idx)}")
          isGoodOdd(i) = isGoodEven(idx)
        }

        numPos.maxBefore(arr(i) + 1).foreach { case (biggestLess, idx) =>
//          println(s"biggestLess: ${biggestLess}, index: $idx")
          isGoodEven(i) = isGoodOdd(idx)
        }
      }

      numPos.put(arr(i), i)

//      println(s"isGoodOdd: ${isGoodOdd.toList}")
//      println(s"isGoodEven: ${isGoodEven.toList}")
//      println(s"numPos: $numPos")
    }

    isGoodOdd.count(a => a)
  }
}

val arr = Array(1, 2, 3, 2, 1, 4, 4, 5)
println(Solution.oddEvenJumps(arr))
//val arr2 = Array(2,3,1,1,4)
//Solution.oddEvenJumps(arr2)
//val arr3 = Array(5,1,3,4,2)
//Solution.oddEvenJumps(arr3)
//val arr4 = Array(14, 13, 15)
//Solution.oddEvenJumps(arr4)
//Solution.isGoodIndex(arr4, 0)
//Solution.oddJump(arr4, 0)
