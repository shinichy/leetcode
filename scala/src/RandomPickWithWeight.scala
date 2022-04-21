import scala.util.Random

object RandomPickWithWeight extends App {
  val rand = Random.between(0, 1)

  class Solution(_w: Array[Int]) {
    val total = _w.sum
    var probs = collection.mutable.ArrayBuffer[Double]()
    var currentTotal = 0d

    for {
      v <- _w
    } {
      val d = v / total.toDouble
      probs += currentTotal + d
      currentTotal += d
    }

    //println(s"probs: ${probs.toList}")

    def lowerBound(array: Array[Double], v: Double): Int = {
      lowerBoundInternal(array, v, 0, array.length - 1)
    }

    def lowerBoundInternal(array: Array[Double], v: Double, low: Int, high: Int): Int = {
      //println(s"low: $low, high: $high")

      if (high == low) {
        high
      } else {
        val mid = (low + high) / 2

        if (array(mid) < v) {
          lowerBoundInternal(array, v, mid + 1, high)
        } else {
          lowerBoundInternal(array, v, low, mid)
        }
      }
    }

    def pickIndex(): Int = {
      val rand = Random.nextDouble()
      //println(s"rand: $rand")
      lowerBound(probs.toArray, rand)
    }
  }

  val solution = new Solution(Array(1, 2, 3))
  //println(solution.pickIndex())
}

// probs: Array(0.16,0.49333333, 0.999)
