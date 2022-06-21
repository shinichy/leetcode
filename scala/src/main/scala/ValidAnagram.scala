object ValidAnagram {
  def main(args: Array[String]): Unit = {
    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("rat", "car"))
  }

  def isAnagram(s: String, t: String): Boolean = {
    if (s.length != t.length) {
      return false
    }

    val counter = Array.fill[Int](26)(0)

    for {
      i <- s.indices
    } {
      counter(s(i) - 'a') += 1
      counter(t(i) - 'a') -= 1
    }

    counter.forall(_ == 0)
  }
}
