object Atoi {
  def main(args: Array[String]): Unit = {
    println(myAtoi("42"))
    println(myAtoi("   -42"))
    println(myAtoi("4193 with words"))
    println(myAtoi(s"${Int.MaxValue.toLong + 10} with words"))
    println(myAtoi("-91283472332"))
    println(myAtoi(""))
    println(myAtoi("9223372036854775808"))
  }

  def myAtoi(s: String): Int = {
    var i = 0
    var sign = 1

    // skip whitespaces
    while (i < s.length && s(i) == ' ') {
      i += 1
    }

    if (i < s.length && s(i) == '+') {
      i += 1
    } else if (i < s.length && s(i) == '-') {
      i += 1
      sign = -1
    }

    var j = i
    while (j < s.length && s(j).isDigit) {
      j += 1
    }

    val numStr = s.substring(i, j)

    var num = 0
    for {
      c <- numStr
    } {
      val digit = (c.toInt - '0'.toInt)

      if (
        (num > Int.MaxValue / 10) || (num == Int.MaxValue / 10 && digit > Int.MaxValue % 10)
      ) {
        return if (sign == 1) Int.MaxValue else Int.MinValue
      }

      num = num * 10 + digit
    }

    // println(s"num: $num")
    sign * num.toInt
  }
}
