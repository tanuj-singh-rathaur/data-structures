package arrays.kadane;

import util.Test;

/**
 * Maximum Subarray Sum with One Deletion
 * Pattern : Kadane with two states (deleted / not-deleted)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 * ─────────────────────────────────────────────
 * You may delete AT MOST one element. Return the max subarray sum after
 * (optional) deletion. The subarray must remain non-empty.
 */
public class P05_Maximum_Subarray_Sum_with_One_Deletion {

    public int maximumSum(int[] arr) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P05_Maximum_Subarray_Sum_with_One_Deletion sol = new P05_Maximum_Subarray_Sum_with_One_Deletion();
        Test.equal("Test 1", sol.maximumSum(new int[]{1,-2,0,3}), 4);
        Test.equal("Test 2", sol.maximumSum(new int[]{1,-2,-2,3}), 3);
        Test.equal("Test 3", sol.maximumSum(new int[]{-1,-1,-1,-1}), -1);
        Test.summary();
    }
}
