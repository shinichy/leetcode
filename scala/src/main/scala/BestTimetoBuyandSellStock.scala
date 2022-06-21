object BestTimetoBuyandSellStock {
  def main(args: Array[String]): Unit = {
    println(maxProfit(Array(2,4,1)))
  }

  def maxProfit(prices: Array[Int]): Int = {
    var buy: Int = Int.MaxValue
    var maxprofit: Int = 0

    for {
      p <- prices
    } {
      if (p < buy) {
        buy = p
      } else if (p - buy > maxprofit) {
        maxprofit = p - buy
      }
    }

    maxprofit
  }
}
