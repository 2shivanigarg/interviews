//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//        For example, given n = 3, a solution set is:
//
//        [
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisRecursive(n, result, "", 0, 0);
        return result;
    }

    public void generateParenthesisRecursive(int n, List<String> result, String current, int open, int close) {
        if(current.length() == n * 2) {
            result.add(current);
            return;
        }

        if(open < n) {
            generateParenthesisRecursive(n, result, current + "(", open + 1, close);
        }

        if(close < open) {
            generateParenthesisRecursive(n, result, current + ")", open, close + 1);
        }
    }
}