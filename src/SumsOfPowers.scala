object Solution {


  def numberOfWays(X:Int,N:Int):Int = {
    // Compute the answer in this function over here
    // It is fine to define new functions as and where required
    def find(c:Int, list: List[Int], min: Int): Int = {
      c match {
        case X => 1
        case i if i > X => 0
        case _ => (min to X).filter(Math.pow(_, N) <= X).diff(list).map(x => find(c + Math.pow(x, N).toInt, x :: list, x)).sum
      }
    }
    find(0, List(), 1)
  }

  def main(args: Array[String]) {
    println(numberOfWays(readInt(),readInt()))
  }
}