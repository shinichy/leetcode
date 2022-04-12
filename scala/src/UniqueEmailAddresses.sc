object Solution {
    def numUniqueEmails(emails: Array[String]): Int = {
        val pairs = for {
            email <- emails
        } yield {
            val Array(localName, domainName) = email.split('@')
            (normalize(localName), domainName)
        }

        pairs.toSet.size
    }

    def removePlusStr(str: String): String = {
        val plusSignIndex = str.indexOf('+')
        if (0 <= plusSignIndex) {
            str.substring(0, plusSignIndex)
        } else {
            str
        }
    }

    def removeDots(str: String): String = {
        str.replaceAll("\\.", "")
    }

    def normalize(str: String) = {
        removeDots(removePlusStr(str))
    }
}

//val emails = Array("test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com")
val emails = Array("alice.z@leetcode.com","alicez@leetcode.com", "alicez@leet.code.com")
Solution.numUniqueEmails(emails)
//Solution.removePlusStr("m.y+name")
//Solution.removeDots("m.y+name")
//Solution.normalize("m.y+name")

// Steps
// For each email,
    // Split a string into local and domain names
    // e.g. "alice.z@leetcode.com" -> "alice.z" and "leetcode.com
    // Remove string that starts with '+'. e.g. "m.y+name" -> "m.y"
    // Remove all '.'s in the local name. e.g. "m.y.x" -> "myx"
// At this moment, we have a list of paris of a normalized local name and a domain name
// Convert the list to set to remove duplication
// Count the set
