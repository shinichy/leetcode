object ValidPalindrome {
  def main(args: Array[String]): Unit = {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
    println(isPalindrome(" "))
  }

  def isPalindrome(s: String): Boolean = {
    var i = 0
    var j = s.length - 1

    while (i < j) {
      while (i < j && !s(i).isLetterOrDigit) {
        i += 1
      }
      while (i < j && !s(j).isLetterOrDigit) {
        j -= 1
      }

      if (s(i).toLower != s(j).toLower) {
        return false
      }

      i += 1
      j -= 1
    }

    true
  }
}
