object Permutations {
  def main(args: Array[String]): Unit = {
    val results = collection.mutable.ArrayBuffer[Array[Int]]()
    permutate(results, Array(1, 2, 3), 0)
    println(results.map(_.toList).toList)
  }

  // def permutations(nums):
  //   """ Generate a list of permutations from the initial list of numbers
  //   """
  //   results = []
  //   def swap(array, i, j):
  //       if i != j:
  //           array[i], array[j] = array[j], array[i]

  //   def permutate(array, start):
  //       if start == len(array):
  //           # make a deep copy of the generated permutation
  //           results.append(list(array))

  //       for i in range(start, len(array)):
  //           # change the candidate list for the following permutations
  //           swap(array, i, start)
  //           permutate(array, start+1)
  //           # backtrack so that we could try out other options
  //           swap(array, i, start)
  //   # run the permutations
  //   permutate(nums, 0)
  //   return results

  def permutate(
      results: collection.mutable.ArrayBuffer[Array[Int]],
      array: Array[Int],
      start: Int
  ): Unit = {
    if (start == array.length) {
      results += array.clone()
    }

    for {
      i <- start until array.length
    } {
      swap(array, i, start)
      permutate(results, array, start + 1)
      swap(array, i, start)
    }
  }

  def swap(array: Array[Int], i: Int, j: Int) {
    val tmp = array(i)
    array(i) = array(j)
    array(j) = tmp
  }
}
