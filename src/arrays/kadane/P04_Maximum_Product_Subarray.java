package arrays.kadane;

import util.Test;

/**
 * Maximum Product Subarray
 * Pattern : Kadane (track max AND min because negatives flip them)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-product-subarray/
 * ─────────────────────────────────────────────
 * Return the max product of any contiguous subarray.
 */
public class P04_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P04_Maximum_Product_Subarray sol = new P04_Maximum_Product_Subarray();
        Test.equal("Test 1", sol.maxProduct(new int[]{2,3,-2,4}), 6);
        Test.equal("Test 2", sol.maxProduct(new int[]{-2,0,-1}), 0);
        Test.equal("Test 3", sol.maxProduct(new int[]{-2,3,-4}), 24);
        Test.summary();
    }
}
