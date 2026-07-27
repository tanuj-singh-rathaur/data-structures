package arrays.prefixsum;

import util.Test;

/**
 * Number of Submatrices That Sum to Target
 * Pattern : Fix row pair, reduce to 1-D "Subarray Sum Equals K" on column sums
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 */
public class P12_Number_of_Submatrices_That_Sum_to_Target {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P12_Number_of_Submatrices_That_Sum_to_Target sol = new P12_Number_of_Submatrices_That_Sum_to_Target();
        Test.equal("Test 1", sol.numSubmatrixSumTarget(new int[][]{{0,1,0},{1,1,1},{0,1,0}}, 0), 4);
        Test.equal("Test 2", sol.numSubmatrixSumTarget(new int[][]{{1,-1},{-1,1}}, 0), 5);
        Test.equal("Test 3", sol.numSubmatrixSumTarget(new int[][]{{904}}, 0), 0);
        Test.summary();
    }
}
