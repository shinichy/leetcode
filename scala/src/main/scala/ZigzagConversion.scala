object ZigzagConversion {
  def main(args: Array[String]): Unit = {
    println(convert("PAYPALISHIRING", 3))
    println(convert("PAYPALISHIRING", 4))
    println(convert("A", 1))
    println(convert("AB", 1))
  }

  def convert(s: String, numRows: Int): String = {
    val lists =
      (0 until numRows).map(_ => collection.mutable.ArrayBuffer[Char]())
    var i = 0
    var diff = 0

    for {
      c <- s
    } {
      lists(i) += c

      if (1 < numRows) {
        if (i == numRows - 1) {
          diff = -1
        } else if (i == 0) {
          diff = 1
        }
      }

      i += diff
    }

    lists.flatten.mkString
  }
}
