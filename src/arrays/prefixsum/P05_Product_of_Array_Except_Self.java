package arrays.prefixsum;

import util.Test;

/**
 * Product of Array Except Self
 * Pattern : Prefix product + suffix product (no division)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/product-of-array-except-self/
 * ─────────────────────────────────────────────
 * answer[i] = product of every element except nums[i]. O(n) time, O(1) extra (excluding output).
 */
public class P05_Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        // TODO: implement
        return new int[0];
    }

    public static void main(String[] args) {
        P05_Product_of_Array_Except_Self sol = new P05_Product_of_Array_Except_Self();
        Test.equal("Test 1", sol.productExceptSelf(new int[]{1,2,3,4}), new int[]{24,12,8,6});
        Test.equal("Test 2", sol.productExceptSelf(new int[]{-1,1,0,-3,3}), new int[]{0,0,9,0,0});
        Test.summary();
    }
}
