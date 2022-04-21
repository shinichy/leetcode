object DecodeString extends App {
  def decodeString(s: String): String = {
    val stack = collection.mutable.Stack[String]()
    //println(s"splitted: ${split(s).toList}")

    for {
      word <- split(s)
    } {
      if (word == "]") {
        val strings = collection.mutable.ListBuffer[String]()
        var content = stack.pop()
        while (content != "[") {
          strings.prepend(content)
          content = stack.pop()
        }
        val k = stack.pop()
        stack.push(strings.mkString * (k.toInt))
      } else {
        stack.push(word)
      }
    }

    //println(s"stack: $stack")
    val strings = collection.mutable.ListBuffer[String]()
    while (stack.nonEmpty) {
      strings.prepend(stack.pop())
    }

    strings.mkString
  }

  def split(s: String): Array[String] = {
    val array = collection.mutable.ArrayBuffer[String]()
    var i = 0

    while (i < s.length) {
      if (s(i).isDigit) {
        var end = i
        while (s(end).isDigit) {
          end += 1
        }

        array.append(s.substring(i, end))
        i = end
      } else if (s(i).isLetter) {
        var end = i
        while (end < s.length && s(end).isLetter) {
          end += 1
        }

        array.append(s.substring(i, end))
        i = end
      } else {
        array.append(s(i).toString)
        i += 1
      }
    }

    array.toArray
  }

  println(decodeString("10[ab2[c]]"))
  println(decodeString("3[a]2[bc]"))
  println(decodeString("3[a2[c]]"))
  println(decodeString("2[abc]3[cd]ef"))
}

// Split: 10, [, ab, 2, [, c, ], ]
