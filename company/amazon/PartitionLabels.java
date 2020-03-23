//A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
//
//        Example 1:
//        Input: S = "ababcbacadefegdehijhklij"
//        Output: [9,7,8]
//        Explanation:
//        The partition is "ababcbaca", "defegde", "hijhklij".
//        This is a partition so that each letter appears in at most one part.
//        A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
//        Note:
//
//        S will have length in range [1, 500].
//        S will consist of lowercase letters ('a' to 'z') only.

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> partitionLengths = new ArrayList<>();
        int[] lastIndexes = new int[26];
        for(int i = 0; i < S.length(); i++) {
            lastIndexes[S.charAt(i) - 'a'] = i;
        }

        int i = 0;
        while(i < S.length()) {
            int end = lastIndexes[S.charAt(i) - 'a'];
            // Need to start j from i for the case where one partition is at the 1st character itself
            // Eg. "caedbdedda"
            // Answer: [1, 9]
            int j = i;
            while(j != end) {
                end = Math.max(end, lastIndexes[S.charAt(j) - 'a']);
                j++;
            }

            partitionLengths.add(j - i + 1);
            i = j + 1;
        }

        return partitionLengths;
    }
}