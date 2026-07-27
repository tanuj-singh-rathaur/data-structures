package arrays.prefixsum;

import util.Test;

/**
 * Range Sum Query — Immutable
 * Pattern : Prefix Sum precomputed at construction
 * Difficulty: Easy
 * LeetCode : https://leetcode.com/problems/range-sum-query-immutable/
 * ─────────────────────────────────────────────
 * Support sumRange(l, r) in O(1) after O(n) precompute.
 * sum(l..r) = prefix[r+1] − prefix[l].
 */
public class P03_Range_Sum_Query___Immutable {

    private int[] prefix;

    public P03_Range_Sum_Query___Immutable() {}

    public P03_Range_Sum_Query___Immutable(int[] nums) {
        // TODO: build prefix sums
    }

    public int sumRange(int left, int right) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P03_Range_Sum_Query___Immutable obj = new P03_Range_Sum_Query___Immutable(new int[]{-2,0,3,-5,2,-1});
        Test.equal("Test 1", obj.sumRange(0,2), 1);
        Test.equal("Test 2", obj.sumRange(2,5), -1);
        Test.equal("Test 3", obj.sumRange(0,5), -3);
        Test.summary();
    }
}
