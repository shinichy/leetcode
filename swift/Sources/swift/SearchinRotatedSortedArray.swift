class Solution {
  var nums: [Int]!
  var target: Int!

  func search(_ nums: [Int], _ target: Int) -> Int {
    self.nums = nums
    self.target = target

    if nums.count == 1 {
      if nums[0] == target {
        return 0
      } else {
        return -1
      }
    }

    if nums[nums.count-1] < nums[0] {
      // if nums is rotated
      let pivot = findRotateIndex(0, nums.count - 1)
      //print("pivot:\(pivot)")
      if target < nums[0] {
        // target is in right side
        return search(pivot, nums.count-1)
      } else {
        // target is in left side
        return search(0, pivot)
      }
    } else {
      // if nums is NOT rotated
      return search(0, nums.count-1)
    }
  }

  func findRotateIndex(_ left: Int, _ right: Int) -> Int {
    // rotateIndex is the index at the smallest value
    //print("findRotateIndex. left:\(left), right:\(right)")
    if left > right {
      return 0
    }

    let mid = (right + left) / 2
    //print("mid:\(mid)")
    if nums[mid] > nums[mid+1] {
      //print("found pivot:\(mid+1)")
      return mid+1
    }

    if nums[mid] < nums[left] {
      return findRotateIndex(left,mid-1)
    } else {
      return findRotateIndex(mid+1,right)
    }
  }

  // binary search
  func search(_ left: Int, _ right: Int) -> Int {
    //print("search. left:\(left), right:\(right)")
    if left > right {
      return -1
    }

    let mid = (right+left)/2
    //print("mid:\(mid)")

    if nums[mid] == target {
      return mid
    }

    if target < nums[mid] {
      return search(left,mid-1)
    } else {
      return search(mid+1,right)
    }
  }
}

//print(Solution().search([4,5,6,7,0,1,2], 0))
//print(Solution().search([2,4,5,6,7,0,1], 0))
//print(Solution().search([4,5,6,7,0,1,2], 3))
//print(Solution().search([1], 2))
//print(Solution().search([1,3], 2))
//print(Solution().search([3,1], 0))
//print(Solution().search([1,3], 4))
//print(Solution().search([3,1], 1))
//print(Solution().search([8,9,2,3,4], 9))
