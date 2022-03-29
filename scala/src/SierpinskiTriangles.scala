/**
 * @author shinichi
 */
object SierpinskiTriangles extends App {
  def line(num: Int, width: Int): String = {
    def underscores(x: Int): String = "_" * x
    def ones(x: Int): String = "1" * x
    def underscoreWidth: Int = (width - num) / 2
    underscores(underscoreWidth) + ones(num) + underscores(underscoreWidth)
  }

  def triangle(height: Int): Seq[String] = {
    require(height >= 1)
    def width: Int = height * 2 - 1
    for (i <- 1 to height) yield line(i * 2 - 1, width)
  }

  def emptySquareBox(height: Int): Seq[String] = {
    for (i <- 1 to height) yield "_" * height
  }

  def emptyLongBox(height: Int): Seq[String] = for (i <- 1 to height) yield "_"

  def sierpinskiTriangle(i: Int, height: Int): Seq[String] = {
    i match {
      case 0 => triangle(height)
      case _ =>
        def newHeight = height / 2
        (emptySquareBox(newHeight), sierpinskiTriangle(i - 1, newHeight), emptySquareBox(newHeight)).zipped.map(_ + _ + _) ++
          (sierpinskiTriangle(i - 1, newHeight), emptyLongBox(newHeight), sierpinskiTriangle(i - 1, newHeight)).zipped.map(_ + _ + _)

    }
  }

  sierpinskiTriangle(0, ROWS) foreach println
  sierpinskiTriangle(1, ROWS) foreach println
  sierpinskiTriangle(2, ROWS) foreach println
}
