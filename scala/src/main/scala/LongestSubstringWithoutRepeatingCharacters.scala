object LongestSubstringWithoutRepeatingCharacters {
  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring("aab"))
    println(lengthOfLongestSubstring("aabaab!bb"))
  }

  def lengthOfLongestSubstring(s: String): Int = {
    var ans = 0
    var i = 0
    val mp = collection.mutable.Map[Char,Int]()

    for {
      j <- s.indices
    } {
      if (mp.contains(s(j))) {
        i = Math.max(mp(s(j)) + 1, i)
      }

      ans = Math.max(ans, j - i + 1)
      mp += s(j) -> j

      // println(s"mp: $mp, ans: $ans, i: $i, j: $j")
    }

    ans
  }
}
