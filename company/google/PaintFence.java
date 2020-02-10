// There is a fence with n posts, each post can be painted with one of the k colors.

// You have to paint all the posts such that no more than two adjacent fence posts have the same color.

// Return the total number of ways you can paint the fence.

// Note:
// n and k are non-negative integers.

public class PaintFence {
    public int numWays(int n, int k) {
        if(n <= 0) {
            return 0;
        }

        if(n == 1) {
            return k;
        }

        /**
         * Here is the case for n = 2
         * There are 2 choices: Paint both the post of same color or paint both the post of different color
         * 1. Same Color: k (there are k choices since we have k colors)
         * 2. Different Color: k * (k - 1) (1st post has k color choices to be painted and 2nd post will have
         * k - 1 color choices to be painted)
         * Eventually the answer will be either paint posts with same color or different
         * So, answer = same + different
         */
        int same = k;
        int different = k * (k - 1);

        /**
         * Now, calculating for posts from n >= 3
         */
        for(int i = 3; i <= n; i++) {
            // Holding the previous different
            int previousDifferent = different;
            // There are 2 possibilities that the next post can be made either of same color or different color.
            /**
             * Case 1: Making the current post of different color
             * Here, there are 2 choices that previous can be either of same color or different color.
             * And the number of choices for current post will be k - 1.
             * So, 2 cases:
             * 1. same * (k - 1)
             * 2. different * (k - 1)
             * Overall summation would be:
             * different = (same + different) * (k - 1)
             */
            different = (same + different) * (k - 1);
            /**
             * Case 2: Making the current post of same color
             * In this case, previous cannot be of same color because in that case all the 3 posts will be of
             * same color and it will violate our constraint.
             * So, the only choice is that the previous should be different (previousDifferent) and paint this post with the last
             * chosen color (which will just 1 choice)
             * Hence, this case would be:
             * same = previousDifferent * 1
             */
            same = previousDifferent * 1;
        }
        // Result would be summation of same and different as these are the 2 possible choices
        return same + different;
    }
}