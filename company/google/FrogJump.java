// A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

// Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

// If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

// Note:

// The number of stones is ≥ 2 and is < 1,100.
// Each stone's position will be a non-negative integer < 231.
// The first stone's position is always 0.
// Example 1:

// [0,1,3,5,6,8,12,17]

// There are a total of 8 stones.
// The first stone at the 0th unit, second stone at the 1st unit,
// third stone at the 3rd unit, and so on...
// The last stone at the 17th unit.

// Return true. The frog can jump to the last stone by jumping 
// 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
// 2 units to the 4th stone, then 3 units to the 6th stone, 
// 4 units to the 7th stone, and 5 units to the 8th stone.
// Example 2:

// [0,1,2,3,4,8,9,11]

// Return false. There is no way to jump to the last stone as 
// the gap between the 5th and 6th stone is too large.

class Solution {
    public boolean canCross(int[] stones) {
        /**
         * If the stones are perfected aligned at pos 0,1,3,6,10,..., i-2, i-1, i, we can see that each 
         * step we jump one unit more than the previous, therefore, we jump i-1 units to reach (i-1)th           
         * stone. In this case, our next jump should be no further than i units. If the ith stones is              
         * further away than i units, then we can't make it.
         * 
         * Hence, the below check is necessary otherwise we'll get TLE for the input:
         * https://leetcode.com/submissions/detail/285008192/testcase/
         * 
         * The loop starts from 3 since stones[0], stones[1] and stones[2] i.e. 0, 1, 2 
         * will not satisfy the condition.
         * 
         **/
        
        for(int i = 3; i < stones.length; i++) {
            if(stones[i] > stones[i - 1] * 2) {
                return false;
            }
        }
        
        HashSet<Integer> stonePositions = new HashSet<>();
        for(int stone: stones) {
            stonePositions.add(stone);
        }
        
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();
        positions.add(0);
        jumps.add(0);
        
        int lastStone = stones[stones.length - 1];
        
        while(!positions.isEmpty()) {
            int position = positions.pop();
            int jumpDistance = jumps.pop();
            for(int i = jumpDistance - 1; i <= jumpDistance + 1; i++) {
                if(i <= 0) {
                    continue;
                }
                
                int nextPosition = position + i;
                if(nextPosition == lastStone) {
                    return true;
                } else if(stonePositions.contains(nextPosition)) {
                    positions.push(nextPosition);
                    jumps.push(i);
                }
            }
        }
        
        return false;
    }
}
