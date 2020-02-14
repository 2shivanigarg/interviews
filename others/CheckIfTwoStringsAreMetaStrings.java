//Given two strings, the task is to check whether these strings are meta strings or not.
//        Meta strings are the strings which can be made equal by exactly one swap in any of the strings.
//        Equal string are not considered here as Meta strings.
//
//        Examples:
//
//        Input : str1 = "geeks"
//        str2 = "keegs"
//        Output : Yes
//        By just swapping 'k' and 'g' in any of string,
//        both will become same.
//
//        Input : str1 = "rsting"
//        str2 = "string
//        Output : No
//
//        Input :  str1 = "Converse"
//        str2 = "Conserve"

/**
 * Below are steps used in the algorithm.
 *
 * 1. Check if both strings are of equal length or not, if not return false.
 * 2. Otherwise, start comparing both strings and count number of unmatched characters
 *      and also store the index of unmatched characters.
 * 3. If unmatched characters are more than 2 then return false.
 * 4. Otherwise check if on swapping any of these two characters
 *      in any string would make the string equal or not.
 * 5. If yes then return true. Otherwise return false.
 */
class Solution {
    public boolean areMetaStrings(String s1, String s2) {
        if((s1 == null || s1.length == 0) || (s2 == null || s2.length == 0)) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 != len2) {
            return false;
        }

        int mismatchCount = 0;
        int previousMismatchIndex = -1;
        int currentMismatchIndex = -1;

        for(int i = 0; i < len1; i++) {
            if(s1.charAt(i) != s2.charAt(s2)) {
                count++;

                if(count > 2) {
                    return false;
                }

                previousMismatchIndex = currentMismatchIndex;
                currentMismatchIndex = i;
            }
        }

        return (mismatchCount == 2 &&
                s1.charAt(previousMismatchIndex) == s2.charAt(currentMismatchIndex) &&
                s1.charAt(currentMismatchIndex) == s1.charAt(previousMismatchIndex));
    }
}