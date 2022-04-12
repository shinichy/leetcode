object Solution {
  def doClimbStairs(n: Int, a: Int, b: Int): Int = {
    n match {
      case 0 => a
      case _ => doClimbStairs(n - 1, b, a + b)
    }
  }

  def climbStairs(n: Int) = doClimbStairs(n - 1, 1, 2)

  //  val steps: Stream[Int] = 1 #:: 2 #:: steps.zip(steps.tail).map(p => p._1 + p._2)
  //  def climbStairs(n: Int) = steps(n-1)
}

FindSubtree.climbStairs(2)

//val fib: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fib.zip(fib.tail).map(p => p._1 + p._2)
//
//def fib4(n: Int) = fib(n)


// n = 4
// 1 + 1 + 1 + 1
// 1 + 1 + 2
// 1 + 2 + 1
// 2 + 1 + 1
// 2 + 2

