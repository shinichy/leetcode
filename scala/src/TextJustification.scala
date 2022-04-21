object TextJustification extends App {
  def fullJustify(words: Array[String], maxWidth: Int): List[String] = {
    var line = collection.mutable.ArrayBuffer[String]()
    var lines = collection.mutable.ArrayBuffer[Array[String]]()
    var width = 0
    var i = 0

    while (i < words.length) {
      var word = words(i)
      var newWidth = line.map(_.length).sum + word.length + line.length

      if (newWidth <= maxWidth) {
        line.append(word)
        //        width = newWidth
        i += 1
      } else {
        lines += line.toArray
        line.clear()
        //        width = 0
      }
    }

    if (line.nonEmpty) {
      lines += line.toArray
    }

    val lastLine = leftJustify(lines.last, maxWidth)
    lines.dropRight(1).map(justify(_, maxWidth)).toList :+ lastLine
  }

  def justify(line: Array[String], maxWidth: Int): String = {
    var charLength = line.map(_.length).sum
    //println(s"charLength: $charLength")
    var widthForSpace = maxWidth - charLength
    //println(s"widthForSpace: $widthForSpace")
    var numSpaces = Math.max(1, (line.length - 1))
    //println(s"numSpaces: $numSpaces")
    var baseSpaceWidth = widthForSpace / numSpaces

    //println(s"baseSpaceWidth: $baseSpaceWidth")
    var numMaxSpace = widthForSpace - (baseSpaceWidth * numSpaces)
    //println(s"numMaxSpace: $numMaxSpace")
    var j = 0
    var sb = new StringBuilder()

    for {
      i <- 0 until line.length
    } {
      sb.append(line(i))

      if (i < numSpaces) {
        if (j < numMaxSpace) {
          sb.append(" " * (baseSpaceWidth + 1))
          j += 1
        } else {
          sb.append(" " * baseSpaceWidth)
        }
      }
    }

    sb.toString()
  }

  def leftJustify(line: Array[String], maxWidth: Int): String = {
    //println(s"line: ${line.toList}")
    var charLength = line.map(_.length).sum
    //println(s"charLength: $charLength")
    var spaceLength = line.length - 1
    var lastSpaceLength = maxWidth - charLength - spaceLength
    line.mkString(" ") + " " * (lastSpaceLength)
  }

  val words = Array("This", "is", "an", "example", "of", "text", "justification.")
//  //println(fullJustify(words, 16))
  val words2 = Array("What", "must", "be", "acknowledgment", "shall", "be")
//  //println(fullJustify(words2, 16))
  val words3 = Array("Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do")
//  //println(fullJustify(words3, 20))
  val words4 = Array("The", "important", "thing", "is", "not", "to", "stop", "questioning.", "Curiosity", "has", "its", "own", "reason", "for", "existing.")
//  //println(fullJustify(words4, 17))
  //  //println(justify(Array("Science","is","what","we"), 20))
  //  //println(justify(Array("example", "of", "text"), 16))
  //    //println(justify(Array("acknowledgment"), 16))
  //  //println(justify(Array("own", "reason", "for"), 17))
//  //println(justify(Array("what", "you", "can", "do"), 16))
  //      //println(leftJustify(Array("shall", "be"), 16))
}

//"what  you can do"
