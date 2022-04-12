object Solution {
    def reverseString(s: Array[Char]): Unit = {
        var begin = 0
        var end = s.length - 1
        
        while (begin < end) {
            val ch = s(begin)
            s(begin) = s(end)
            s(end) = ch
            begin += 1
            end -= 1
        }
    }
}

val s = Array('h','e','l','l','o')
FindSubtree.reverseString(s)
println(s.toList)

// State
// beginIndex, endIndex

// Logic
// Swap characters at begin and end indices.
// Repeat until end <= begin
