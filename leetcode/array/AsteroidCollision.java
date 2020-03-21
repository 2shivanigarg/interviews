//We are given an array asteroids of integers representing asteroids in a row.
//
//        For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
//        Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
//
//        Example 1:
//        Input:
//        asteroids = [5, 10, -5]
//        Output: [5, 10]
//        Explanation:
//        The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
//        Example 2:
//        Input:
//        asteroids = [8, -8]
//        Output: []
//        Explanation:
//        The 8 and -8 collide exploding each other.
//        Example 3:
//        Input:
//        asteroids = [10, 2, -5]
//        Output: [10]
//        Explanation:
//        The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
//        Example 4:
//        Input:
//        asteroids = [-2, -1, 1, 2]
//        Output: [-2, -1, 1, 2]
//        Explanation:
//        The -2 and -1 are moving left, while the 1 and 2 are moving right.
//        Asteroids moving the same direction never meet, so no asteroids will meet each other.
//        Note:
//
//        The length of asteroids will be at most 10000.
//        Each asteroid will be a non-zero integer in the range [-1000, 1000]..

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < asteroids.length) {
            if(asteroids[i] > 0) {
                // Adding positive values to stack
                stack.push(asteroids[i]);
            } else {
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    // This is the case of collision
                    // Current asteroid will blow up the top of stack
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0) {
                    // Either stack is empty or top of stack is negative then,
                    // asteroids are moving in same direction and we'll push the current value in stack
                    stack.push(asteroids[i]);
                } else if(stack.peek() == Math.abs(asteroids[i])) {
                    // Case when stack's top and current asteroid are equal in value
                    stack.pop();
                }
            }
            i++;
        }

        int[] result = new int[stack.size()];
        for(int j = stack.size() - 1; j >=0; j--) {
            result[j] = stack.pop();
        }

        return result;
    }
}