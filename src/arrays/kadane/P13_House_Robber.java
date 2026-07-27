package arrays.kadane;

import util.Test;

/**
 * House Robber
 * Pattern : DP take/skip (rolling two-variable)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/house-robber/
 * ─────────────────────────────────────────────
 * dp[i] = max(dp[i−1], dp[i−2] + nums[i]).
 */
public class P13_House_Robber {

    public int rob(int[] nums) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P13_House_Robber sol = new P13_House_Robber();
        Test.equal("Test 1", sol.rob(new int[]{1,2,3,1}), 4);
        Test.equal("Test 2", sol.rob(new int[]{2,7,9,3,1}), 12);
        Test.equal("Test 3", sol.rob(new int[]{2,1,1,2}), 4);
        Test.summary();
    }
}
