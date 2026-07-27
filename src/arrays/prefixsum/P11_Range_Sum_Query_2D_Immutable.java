package arrays.prefixsum;

import util.Test;

/**
 * Range Sum Query 2D — Immutable
 * Pattern : 2-D prefix sum + inclusion-exclusion
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/range-sum-query-2d-immutable/
 * ─────────────────────────────────────────────
 * O(1) region sum after O(mn) precompute:
 * sum(r1,c1,r2,c2) = P[r2+1][c2+1] − P[r1][c2+1] − P[r2+1][c1] + P[r1][c1].
 */
public class P11_Range_Sum_Query_2D_Immutable {

    private int[][] prefix;

    public P11_Range_Sum_Query_2D_Immutable() {}

    public P11_Range_Sum_Query_2D_Immutable(int[][] matrix) {
        // TODO: build 2D prefix sums
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        int[][] m = {
            {3,0,1,4,2},
            {5,6,3,2,1},
            {1,2,0,1,5},
            {4,1,0,1,7},
            {1,0,3,0,5}
        };
        P11_Range_Sum_Query_2D_Immutable obj = new P11_Range_Sum_Query_2D_Immutable(m);
        Test.equal("Test 1", obj.sumRegion(2,1,4,3), 8);
        Test.equal("Test 2", obj.sumRegion(1,1,2,2), 11);
        Test.equal("Test 3", obj.sumRegion(1,2,2,4), 12);
        Test.summary();
    }
}
