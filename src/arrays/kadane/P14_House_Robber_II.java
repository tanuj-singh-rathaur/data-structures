package arrays.kadane;

import util.Test;

/**
 * House Robber II (circular houses)
 * Pattern : Two independent Rob() calls
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/house-robber-ii/
 * ─────────────────────────────────────────────
 * Houses form a circle so first and last are neighbours.
 * Return max(rob(nums[0..n−2]), rob(nums[1..n−1])).
 */
public class P14_House_Robber_II {

    public int rob(int[] nums) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P14_House_Robber_II sol = new P14_House_Robber_II();
        Test.equal("Test 1", sol.rob(new int[]{2,3,2}), 3);
        Test.equal("Test 2", sol.rob(new int[]{1,2,3,1}), 4);
        Test.equal("Test 3", sol.rob(new int[]{1,2,3}), 3);
        Test.equal("Test 4", sol.rob(new int[]{5}), 5);
        Test.summary();
    }
}
