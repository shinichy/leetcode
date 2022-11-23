class Solution {
    var visited:[[Bool]] = []
    var result = 0
    
    func numIslands(_ grid: [[Character]]) -> Int {
        visited = Array(repeating: Array(repeating: false, count: grid[0].count), count: grid.count)
        let m = grid.count
        let n = grid[0].count
        
        for i in grid.indices {
            for j in grid[0].indices {
                // print("i:\(i), j:\(j)")
                
                if grid[i][j] == "1", !visited[i][j] {
                    result += 1
                    // Find an island starting from i,j
                    findIsland(grid, i, j, m, n)
                }
            }
        }
        
        return result
    }
    
    func findIsland(_ grid: [[Character]], _ i: Int, _ j: Int, _ m: Int, _ n: Int) {
        if grid[i][j] == "0" { return }
        
        visited[i][j] = true
        
        let cells = [(i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)].filter {(i2,j2) in i2 >= 0 && j2 >= 0 && i2 < m && j2 < n && !visited[i2][j2]}
        // print(cells)
        
        for (i2, j2) in cells {
            findIsland(grid, i2, j2, m, n)
        }
    }
}

// let grid:[[Character]] = [
//     ["1","1","1","1","0"],
//     ["1","1","0","1","0"],
//     ["1","1","0","0","0"],
//     ["0","0","0","0","0"]
// ]

let grid:[[Character]] = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
]

print(Solution().numIslands(grid))
