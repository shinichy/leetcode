object Pow {
  def main(args: Array[String]): Unit = {
    println(pow(3, 2))
  }

  def pow(x: Long, n: Long): Long = {
    var ret = 1L
    var x2 = x
    var n2 = n
    while (n2 > 0) {
      if ((n2 & 1) == 1L) {
        ret *= x2
      }
      x2 *= x2
      n2 >>= 1
    }
    ret
  }
}
