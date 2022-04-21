import collection.mutable.{Set, Queue}

object Solution extends App {
  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
    var dict = Set[String](wordList: _*)
    var queue = Queue[String]()
    var visited = Set[String]()
    var level = 0

    queue.enqueue(beginWord)
    visited.add(beginWord)
    while (!queue.isEmpty) {
      for {
        k <- 0 until queue.length
      } {
        var word = queue.dequeue
        if (word == endWord) {
          return level + 1
        }

        for {
          i <- 0 until word.length
        } {
          for {
            j <- 0 until 26
          } {
            var charArray = word.toCharArray
            charArray(i) = (97 + j).toChar
            var newWord = charArray.mkString
            if (dict.contains(newWord) && !visited.contains(newWord)) {
              visited.add(newWord)
              queue.enqueue(newWord)
            }
          }
        }
      }

      level += 1
    }

    0
  }
}



//ladderLength("hit", "cog", List("hot", "dot", "dog", "lot", "log"))
//ladderLength("a", "c", List("a", "b", "c"))
//Solution.diff("hit", "hot")
