class TimeMap {
  var map = [String: [(Int, String)]]()

  init() {}

  func set(_ key: String, _ value: String, _ timestamp: Int) {
    if map[key] != nil {
      map[key]!.append((timestamp, value))
    } else {
      map[key] = [(timestamp, value)]
    }
  }

  func get(_ key: String, _ timestamp: Int) -> String {
    if let arr = map[key] {
      // timestamp is larger than the max in arr
      if arr.last!.0 <= timestamp {
        return arr.last!.1
      }

      // timestamp is smaller than the min in arr
      if timestamp <= arr.first!.0 {
        return arr.first!.1
      }

      return binarySearch(arr, 0, arr.count - 1, timestamp)
    }

    return ""
  }

  func binarySearch(_ arr: [(Int, String)], _ left: Int, _ right: Int, _ timestamp: Int) -> String {
    let mid = (left + right) / 2
    if arr[mid].0 == timestamp {
      return arr[mid].1
    }

    // found max timestamp in arr before the timestamp
    if arr[mid].0 < timestamp, timestamp < arr[mid + 1].0 {
      return arr[mid].1
    }

    if arr[mid].0 < timestamp {
      // search right
      return binarySearch(arr, mid + 1, right, timestamp)
    } else {
      // search left
      return binarySearch(arr, left, mid-1, timestamp)
    }
  }
}

let timeMap = TimeMap()
timeMap.set("foo", "bar", 10) // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.set("foo", "bar2", 20) // store the key "foo" and value "bar" along with timestamp = 1.
print(timeMap.get("foo", 5)) // return "bar"
