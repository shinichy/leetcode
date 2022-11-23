class Solution {
  var memo = [String: Bool]()

  func wordBreak(_ s: String, _ wordDict: [String]) -> Bool {
    // print("s:\(s)")
    if let res = memo[s] {
      return res
    }

    for word in wordDict {
      if s.starts(with: word) {
        let s2 = String(s.dropFirst(word.count))
        if s2.isEmpty {
          memo[s] = true
          return true
        }
        if wordBreak(s2, wordDict) {
          memo[s] = true
          return true
        }
      }
    }

    memo[s] = false
    return false
  }
}

// print(Solution().wordBreak("leetcode", ["leet", "code"]))
print(Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"]))
