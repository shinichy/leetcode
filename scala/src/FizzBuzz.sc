object Solution {
    def fizzBuzz(n: Int): List[String] = {
        (1 to n).map(doFizzBuzz).toList
    }

    def doFizzBuzz(n: Int): String = {
        (n % 3, n % 5) match {
            case (0,0) => "FizzBuzz"
            case (0,_) => "Fizz"
            case (_,0) => "Buzz"
            case _ => n.toString
        }
    }
}

FindSubtree.fizzBuzz(15)
