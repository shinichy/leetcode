object Pow {
  def main(args: Array[String]): Unit = {
    println(pow(4, 3))
  }

  def pow(x: Long, n: Long): Long = {
    if (n == 0) {
      1
    } else {
      val a = pow(x, n / 2)

      if (n % 2 == 0) {
        a * a
      } else {
        x * a * a
      }
    }
  }
}
