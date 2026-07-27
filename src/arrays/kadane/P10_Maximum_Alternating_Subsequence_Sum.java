package arrays.kadane;

import util.Test;

/**
 * Maximum Alternating Subsequence Sum
 * Pattern : Kadane (two-state DP — ending at + or −)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-alternating-subsequence-sum/
 * ─────────────────────────────────────────────
 * Pick a subsequence with alternating signs (+, −, +, −, …) starting with +.
 * Return the maximum such sum.
 */
public class P10_Maximum_Alternating_Subsequence_Sum {

    public long maxAlternatingSum(int[] nums) {
        // TODO: implement
        return 0L;
    }

    public static void main(String[] args) {
        P10_Maximum_Alternating_Subsequence_Sum sol = new P10_Maximum_Alternating_Subsequence_Sum();
        Test.equal("Test 1", sol.maxAlternatingSum(new int[]{4,2,5,3}), 7L);
        Test.equal("Test 2", sol.maxAlternatingSum(new int[]{5,6,7,8}), 8L);
        Test.equal("Test 3", sol.maxAlternatingSum(new int[]{6,2,1,2,4,5}), 10L);
        Test.summary();
    }
}
