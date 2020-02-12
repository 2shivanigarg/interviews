//Given a length n, count the number of strings of length n that can be made using ‘a’, ‘b’ and ‘c’
//with at-most one ‘b’ and at-most two ‘c’s allowed.
//
//        Examples :
//
//        Input : n = 3
//        Output : 19
//        Below strings follow given constraints:
//        aaa aab aac aba abc aca acb acc baa
//        bac bca bcc caa cab cac cba cbc cca ccb
//
//        Input  : n = 4
//        Output : 39

class Solution {
    public int countStrings(int n) {
        return countStringsRecursive(n, 1, 2);
    }

    public int countStringsRecursive(int n, int bCount, int cCount) {
        if(bCount < 0 || cCount < 0) {
            return 0;
        }

        if(n == 0) {
            return 1;
        }

        // Only one possible string when both b and c count is 0 i.e. string with all a's
        if(bCount == 0 && cCount == 0) {
            return 1;
        }

        // There are 3 possible cases, take either a or b or c
        int result = 0;
        // Taking a
        result += countStringsRecursive(n - 1, bCount, cCount);
        // Taking b
        result += countStringsRecursive(n - 1, bCount - 1, cCount);
        // Taking c
        result += countStringsRecursive(n - 1, bCount, cCount - 1);

        return result;
    }
}