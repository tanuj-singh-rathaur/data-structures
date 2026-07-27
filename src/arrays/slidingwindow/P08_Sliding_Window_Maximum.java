package arrays.slidingwindow;

import util.Test;

/**
 * Sliding Window Maximum
 * Pattern : Monotonic deque
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/sliding-window-maximum/
 * ─────────────────────────────────────────────
 * For every window of size k, return the max element. Use a monotonic deque
 * that stores indices in decreasing value order.
 */
public class P08_Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // TODO: implement
        return new int[0];
    }

    public static void main(String[] args) {
        P08_Sliding_Window_Maximum sol = new P08_Sliding_Window_Maximum();
        Test.equal("Test 1", sol.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3), new int[]{3,3,5,5,6,7});
        Test.equal("Test 2", sol.maxSlidingWindow(new int[]{1}, 1), new int[]{1});
        Test.summary();
    }
}
