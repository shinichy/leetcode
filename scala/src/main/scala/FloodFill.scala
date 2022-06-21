object FloodFill {
  def main(args: Array[String]): Unit = {
    // println(
    //   floodFill(Array(Array(1, 1, 1), Array(1, 1, 0), Array(1, 0, 1)), 1, 1, 2)
    //     .map(_.toList)
    //     .toList
    // )
    // println(
    //   floodFill(Array(Array(0, 0, 0), Array(0, 0, 0)), 1, 0, 2)
    //     .map(_.toList)
    //     .toList
    // )
    println(
      floodFill(Array(Array(0, 0, 0), Array(0, 0, 0)), 0, 0, 0)
        .map(_.toList)
        .toList
    )
  }

  def floodFill(
      image: Array[Array[Int]],
      sr: Int,
      sc: Int,
      color: Int
  ): Array[Array[Int]] = {
    val oldColor = image(sr)(sc)
    if (oldColor != color) {
      dfs(image, sr, sc, oldColor, color)
    }
    image
  }

  def dfs(
      image: Array[Array[Int]],
      sr: Int,
      sc: Int,
      color: Int,
      newColor: Int
  ) {
    if (image(sr)(sc) == color) {
      image(sr)(sc) = newColor

      if (0 <= sr - 1) {
        dfs(image, sr - 1, sc, color, newColor)
      }
      if (0 <= sc - 1) {
        dfs(image, sr, sc - 1, color, newColor)
      }
      if (sr + 1 <= image.length - 1) {
        dfs(image, sr + 1, sc, color, newColor)
      }
      if (sc + 1 <= image(0).length - 1) {
        dfs(image, sr, sc + 1, color, newColor)
      }
    }
  }
}
