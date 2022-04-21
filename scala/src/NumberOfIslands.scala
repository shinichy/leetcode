object NumberOfIslands extends App {

  def adjacentNewLandIndices(grid: Array[Array[Char]], i: Int, j: Int, visited: collection.mutable.Set[(Int, Int)]): List[(Int, Int)] = {
    val candidates = List(
      (i - 1, j),
      (i, j - 1), (i, j + 1),
      (i + 1, j)
    )
//    println(s"visited: $visited")

    candidates.filter { case (i, j) =>
      0 <= i && i <= grid.length - 1 &&
        0 <= j && j <= grid(i).length - 1 &&
        grid(i)(j) == '1' && !visited.contains((i, j))
    }
  }

  def numIslands(grid: Array[Array[Char]]): Int = {
    var visited = collection.mutable.Set[(Int, Int)]()
    var queue = collection.mutable.Queue[(Int, Int)]()
    var count = 0

    for {
      i <- 0 until grid.length
    } {
      for {
        j <- 0 until grid(i).length
      } {
        if (grid(i)(j) == '1' && !visited.contains((i, j))) {
          count += 1
          visited((i, j)) = true
          queue.enqueue((i, j))

          while (queue.nonEmpty) {
            var (i, j) = queue.dequeue()
//            println(s"i,j: $i, $j")

            for {
              (i2, j2) <- adjacentNewLandIndices(grid, i, j, visited)
            } {
              visited((i2, j2)) = true
              queue.enqueue((i2, j2))
//              println(s"i2,j2: $i2, $j2")
            }
          }

        }
      }
    }

    count
  }
  //
  //  val grid = Array(
  //    Array('1', '1', '1', '1', '0'),
  //    Array('1', '1', '0', '1', '0'),
  //    Array('1', '1', '0', '0', '0'),
  //    Array('0', '0', '0', '0', '0')
  //  )
  //
  //  println(numIslands(grid))


  val grid = Array(
    Array('1', '1', '0', '0', '0'),
    Array('1', '1', '0', '0', '0'),
    Array('0', '0', '1', '0', '0'),
    Array('0', '0', '0', '1', '1')
  )

  println(numIslands(grid))
}
