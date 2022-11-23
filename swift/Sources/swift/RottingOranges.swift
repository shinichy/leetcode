class Solution {
    func orangesRotting(_ grid: [[Int]]) -> Int {
        var q = [((Int,Int), Int)]()
        var result = 0
        var grid = grid
        var freshOrangeCount = 0
        var rottenOrangeCount = 0

        // Putting all rotten oranges
        for i in grid.indices {
            for j in grid[0].indices {
                if grid[i][j] == 2 {
                    q.append(((i,j), 0))
                }
                if grid[i][j] == 1 {
                    freshOrangeCount += 1
                }
            }
        }

        // BFS
        while !q.isEmpty {
            let ((i,j), m) = q.removeFirst()

            result = max(m,result)

            // Get adjacent fresh oranges
            let freshOranges:[(Int,Int)] = [(i-1,j), (i+1,j), (i,j-1), (i,j+1)].filter { (i,j) in
                0 <= i && i < grid.count && 
                0 <= j && j < grid[0].count && 
                grid[i][j] == 1
            }

            for (i,j) in freshOranges {
                q.append(((i,j), m+1))
                grid[i][j] = 2
                rottenOrangeCount += 1
            }
        }

        if rottenOrangeCount == freshOrangeCount {
            return result
        } else {
            return -1
        }
    }
}

let grid = [[2,1,1],[1,1,0],[0,1,1]]
print(Solution().orangesRotting(grid))
let grid2 = [[2,1,1],[0,1,1],[1,0,1]]
print(Solution().orangesRotting(grid2))
let grid3 = [[0,2]]
print(Solution().orangesRotting(grid3))
