object Solution {
  def licenseKeyFormatting(s: String, k: Int): String = {
    val strippedStr = s.replaceAll("-", "")
//    println(s"strippedStr: $strippedStr")
    val lengthOfFirstGroup = strippedStr.length % k
//    println(s"lengthOfFirstGroup: $lengthOfFirstGroup")
    val (firstGroup, remainingStr) = strippedStr.splitAt(lengthOfFirstGroup)
//    println(s"firstGroup: $firstGroup")
//    println(s"remainingStr: $remainingStr")
    val groups = if (firstGroup.isEmpty) {
      remainingStr.sliding(k, k).toList
    } else {
      firstGroup +: remainingStr.sliding(k, k).toList
    }
//    println(s"groups: $groups")
    groups.mkString("-").toUpperCase
  }
}

println(Solution.licenseKeyFormatting("5F3Z-2e-9-w", 4))
println(Solution.licenseKeyFormatting("2-5g-3-J", 2))

// remove "-" from s
// e.g. "2-5g-3-J" -> "25g3J". Set the result to strippedStr
// Calculate modulo k for the length of strippedStr
// e.g. 5 % 2 = 1. Set the result to lengthOfFirstGroup
// Take lengthOfFirstGroup from strippedStr and make as the first group
// e.g. "2" is the first group. The remaining string is "5g3J".
// Split the remaining string into groups
