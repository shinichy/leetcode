object GenerateParentheses {
  def main(args: Array[String]): Unit = {
    println(generateParenthesis(2))
    // println(generateParenthesis2(1))
  }

  // def generateParenthesis(n: Int): List[String] = {
  //   val ocs = List.fill(n)(List('(', ')')).flatten
  //   // todo: implement permutations
  //   ocs.permutations.filter(isValid(_)).map(_.mkString).toList
  // }

  // def isValid(l: List[Char]): Boolean = {
  //   var balance = 0

  //   for {
  //     c <- l
  //   } {
  //     if (c == '(') {
  //       balance += 1
  //     } else {
  //       if (balance <= 0) {
  //         return false
  //       } else {
  //         balance -= 1
  //       }
  //     }
  //   }

  //   balance == 0
  // }

  // def generateParenthesis(n: Int): List[String] = {
  //   val ans = collection.mutable.ArrayBuffer[String]();
  //   backtrack(ans, new StringBuilder(), 0, 0, n)
  //   ans.toList
  // }

  // def backtrack(
  //     ans: collection.mutable.ArrayBuffer[String],
  //     cur: StringBuilder,
  //     open: Int,
  //     close: Int,
  //     max: Int
  // ) {
  //   println(s"ans: $ans, cur: $cur, open: $open, close: $close, max: $max")

  //   if (cur.length == max * 2) {
  //     ans += cur.toString
  //     return
  //   }

  //   if (open < max) {
  //     cur.append("(")
  //     backtrack(ans, cur, open + 1, close, max)
  //     cur.deleteCharAt(cur.length() - 1)
  //   }

  //   if (close < open) {
  //     cur.append(")")
  //     backtrack(ans, cur, open, close + 1, max)
  //     cur.deleteCharAt(cur.length() - 1)
  //   }
  // }

  //   public List<String> generateParenthesis(int n) {
  //     List<String> ans = new ArrayList();
  //     if (n == 0) {
  //         ans.add("");
  //     } else {
  //         for (int c = 0; c < n; ++c)
  //             for (String left: generateParenthesis(c))
  //                 for (String right: generateParenthesis(n-1-c))
  //                     ans.add("(" + left + ")" + right);
  //     }
  //     return ans;
  // }

  def generateParenthesis(n: Int): List[String] = {
    println(s"generateParenthesis($n) is called")
    val ans = collection.mutable.ArrayBuffer[String]();
    if (n == 0) {
      ans += ""
    } else {
      for {
        c <- 0 until n
        left <- generateParenthesis(c)
        right <- generateParenthesis(n-1-c)
      } {
        println(s"c: $c, n: $n, left: $left, right: $right, ans: $ans")
        ans += ("(" + left + ")" + right)
        println(s"ans: $ans")
      }
    }

    println(s"ans: $ans")
    ans.toList
  }
}
