/* All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> repeatedSubsequences = new ArrayList<>();
        HashMap<String, Integer> seen = new HashMap<>();
        int i = 0;
        while(i + 10 <= s.length()) {
            String subsequence = s.substring(i, i + 10);
            i++;
            seen.put(subsequence, seen.getOrDefault(subsequence, 0) + 1);
            if(seen.get(subsequence) == 2) {
                repeatedSubsequences.add(subsequence);
            }
        }

        return repeatedSubsequences;
    }
}g
