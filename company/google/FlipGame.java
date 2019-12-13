/* You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
    you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and
    therefore the other person will be the winner.

    Write a function to compute all possible states of the string after one valid move.
    Example:

    Input: s = "++++";
    Ouput:
    [
        "--++",
        "+--+",
        "++--"
    ]

    Note: If there is no valid move, return empty list [].
 */

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> possibleStates = new ArrayList<>();
        int i = 0;
        while(i < s.length()) {
            int nextMoveIndex = 0;
            if(i == 0) {
                // Get index of 1st ++
                nextMoveIndex = s.substring("++");
            } else {
                // Get index of ++ after i
                nextMoveIndex = s.substring("++", i);
            }

            if(nextMoveIndex == -1) {
                return possibleStates;
            }

            String nextState = s.substring(0, nextMoveIndex) + "--" + s.substring(nextMoveIndex + 2);
            possibleStates.add(nextState);
            i = nextMoveIndex + 1;
        }

        return possibleStates;
    }
}
