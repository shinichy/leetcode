object ShortestPathGridWithObstaclesElimination extends App {
  def shortestPath(grid: Array[Array[Int]], k: Int): Int = {
    val queue = collection.mutable.Queue[(Int, Int, Int, Int)]()
    val visited = collection.mutable.Set[(Int, Int, Int)]()

    queue.enqueue((0, 0, k, 0))
    visited((0, 0, k)) = true

    while (queue.nonEmpty) {
      val (i, j, eliminate, step) = queue.dequeue()

      if (i == grid.length - 1 && j == grid(i).length - 1) {
        return step
      }

      val adjacentCells = Array((i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1))

      for {
        (i2, j2) <- adjacentCells
        if 0 <= i2 && i2 < grid.length && 0 <= j2 && j2 < grid(i2).length
      } {
        if (grid(i2)(j2) == 1 && eliminate > 0 && !visited.contains((i2, j2, eliminate - 1))) {
          visited += ((i2, j2, eliminate - 1))
          queue.enqueue((i2, j2, eliminate - 1, step + 1))
        }

        if (grid(i2)(j2) == 0 && !visited.contains((i2, j2, eliminate))) {
          visited += ((i2, j2, eliminate))
          queue.enqueue((i2, j2, eliminate, step + 1))
        }
      }
    }

    -1
  }

  val grid = Array(Array(0, 0, 0), Array(1, 1, 0), Array(0, 0, 0), Array(0, 1, 1), Array(0, 0, 0))
  println(shortestPath(grid, 1))

  val grid2 = Array(Array(0, 1, 1), Array(1, 1, 1), Array(1, 0, 0))
  println(shortestPath(grid2, 1))
}
