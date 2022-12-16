struct Point: Hashable, CustomStringConvertible {
  var x: Double
  var y: Double
  init(_ x: Double, _ y: Double) {
    self.x = x
    self.y = y
  }

  var description: String {
    return "(\(x), \(y))"
  }
}

class Path: Hashable {
  public func hash(into hasher: inout Hasher) {
    hasher.combine(ObjectIdentifier(self))
  }

  static func == (lhs: Path, rhs: Path) -> Bool {
    return ObjectIdentifier(lhs) == ObjectIdentifier(rhs)
  }

  var first: Point
  var last: Point
  var middle: [Point]

  init(_ path: [Point]) {
    self.first = path.first!
    self.last = path.last!
    self.middle = Array(path[1 ..< path.count - 1])
  }

  var path: [Point] {
    [first] + middle + [last]
  }
}

func connect(_ paths: [[Point]]) -> [[Point]] {
  var dict = [Point: Path]()

  for path in paths {
    let first = path.first!
    let last = path.last!
    let middle = Array(path[1 ..< path.count - 1])

    if dict[first] == nil, dict[last] == nil {
      let newPath = Path(path)
      dict[first] = newPath
      dict[last] = newPath
    } else if let path1 = dict[first] {
      if first == path1.first {
        dict[path1.first] = nil
        dict[path1.last] = nil
        // [Point(2.0, 3.0), Point(4.0, 5.0), Point(5.0, 6.0)],
        // [Point(2.0, 3.0), Point(1.0, 2.0), Point(11.0, 12.0)],
        var copiedMiddle = path1.middle
        copiedMiddle.reverse()
        path1.middle = copiedMiddle + [first] + middle
        path1.first = path1.last
        path1.last = last
        dict[path1.first] = path1
        dict[path1.last] = path1
      } else {
        dict[path1.last] = nil
        path1.middle = path1.middle + [path1.last] + middle
        path1.last = last
        dict[path1.last] = path1
      }
    } else if let path1 = dict[last] {
      if last == path1.last {
        dict[path1.last] = nil
        var copiedMiddle = middle
        copiedMiddle.reverse()
        path1.middle = path1.middle + [path1.last] + copiedMiddle
        path1.last = first
        dict[path1.last] = path1
      } else {
        // [Point(2.0, 3.0), Point(1.0, 2.0), Point(11.0, 12.0)],
        // [Point(1.0, 1.0), Point(1.0, 2.0), Point(2.0, 3.0)],
        dict[path1.first] = nil
        path1.middle = middle + [last] + path1.middle
        path1.first = first
        dict[path1.first] = path1
      }
    }
  }

  return Array(Set(dict.values).map { $0.path })
}

let paths = [
  [Point(2.0, 3.0), Point(4.0, 5.0), Point(5.0, 6.0)],
  [Point(2.0, 3.0), Point(1.0, 2.0), Point(11.0, 12.0)],
  [Point(11.0, 12.0), Point(7.0, 8.0), Point(4.0, 4.0)],
  [Point(1.0, 1.0), Point(3.0, 3.0), Point(5.0, 5.0)],
]

print(connect(paths))
