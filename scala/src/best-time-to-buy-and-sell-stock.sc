object Solution {
  case class State(minBuyPrice: Int, maxProfit: Int)

  def maxProfit(prices: Array[Int]): Int = {
    val state = prices.foldLeft(State(Int.MaxValue, 0)) { case (acc, price) =>
      if (price < acc.minBuyPrice) {
        acc.copy(minBuyPrice = price)
      } else if (acc.maxProfit < price - acc.minBuyPrice) {
        acc.copy(maxProfit = price - acc.minBuyPrice)
      } else {
        acc
      }
    }

    state.maxProfit
  }
}

// State
// min buy price so far

// For each day
// If the price is less than the min buy price, calculate the max profit
// Else skip

//val prices = Array(7, 1, 5, 3, 6, 4)
//val prices = Array(7, 3, 5, 4, 6, 1, 2)
//val prices = Array(7, 6, 4, 3, 1)
val prices = Array(1)
Solution.maxProfit(prices)
