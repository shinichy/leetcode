class Solution {
    func isValid(_ s: String) -> Bool {
        var stack = [Character]()
        let openChs:[Character] = ["(","{","["]
        let map:[Character:Character] = [")":"(", "}":"{", "]":"["]
        
        for c in s {
            if openChs.contains(c) {
                stack.append(c)    
            } else {
                if stack.isEmpty {
                    return false
                }
                let openCh = stack.removeLast()
                if map[c] != openCh {
                    return false
                }
            }
        }
        
        return stack.isEmpty
    }
}

print(Solution().isValid("()"))
