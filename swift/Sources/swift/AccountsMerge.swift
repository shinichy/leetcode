class Solution {
  var visited = [Bool]()
  var map = [String: [Int]]()

  func accountsMerge(_ accounts: [[String]]) -> [[String]] {
    visited = Array(repeating: false, count: accounts.count)
    var res = [[String]]()

    // Build up the graph
    for (i, account) in accounts.enumerated() {
      for j in 1 ..< account.count {
        let email = account[j]
        if map[email] != nil {
          map[email]!.append(i)
        } else {
          map[email] = [i]
        }
      }
    }

    // print("map:\(map)")

    // Perform DFS for accounts and add to results.
    for (i, account) in accounts.enumerated() {
      if visited[i] {
        continue
      }

      let name = account[0]
      var emails = Set<String>()
      dfs(accounts, i, &emails)
      res.append([name] + emails.sorted())
    }

    return res
  }

  func dfs(_ accounts: [[String]], _ i: Int, _ emails: inout Set<String>) {
    if visited[i] {
      return
    }

    visited[i] = true
    for j in 1 ..< accounts[i].count {
      let email = accounts[i][j]
      emails.insert(email)
      if map[email] != nil {
        for neighbor in map[email]! {
          dfs(accounts, neighbor, &emails)
        }
      }
    }
  }
}

print(Solution().accountsMerge([["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["John", "johnsmith@mail.com", "john00@mail.com"], ["Mary", "mary@mail.com"], ["John", "johnnybravo@mail.com"]]))
print(Solution().accountsMerge([["David", "David0@m.co", "David1@m.co"], ["David", "David3@m.co", "David4@m.co"], ["David", "David4@m.co", "David5@m.co"], ["David", "David2@m.co", "David3@m.co"], ["David", "David1@m.co", "David2@m.co"]]))
print(Solution().accountsMerge([["Hanzo", "Hanzo2@m.co", "Hanzo3@m.co"], ["Hanzo", "Hanzo4@m.co", "Hanzo5@m.co"], ["Hanzo", "Hanzo0@m.co", "Hanzo1@m.co"], ["Hanzo", "Hanzo3@m.co", "Hanzo4@m.co"], ["Hanzo", "Hanzo7@m.co", "Hanzo8@m.co"], ["Hanzo", "Hanzo1@m.co", "Hanzo2@m.co"], ["Hanzo", "Hanzo6@m.co", "Hanzo7@m.co"], ["Hanzo", "Hanzo5@m.co", "Hanzo6@m.co"]]))
