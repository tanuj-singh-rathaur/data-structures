package arrays.prefixsum;

import util.Test;

/**
 * Left and Right Sum Differences
 * Pattern : Running leftSum; rightSum derived from total
 * Difficulty: Easy
 * LeetCode : https://leetcode.com/problems/left-and-right-sum-differences/
 * ─────────────────────────────────────────────
 * answer[i] = |leftSum[i] − rightSum[i]|.
 */
public class P19_Left_and_Right_Sum_Differences {

    public int[] leftRightDifference(int[] nums) {
        // TODO: implement
        return new int[0];
    }

    public static void main(String[] args) {
        P19_Left_and_Right_Sum_Differences sol = new P19_Left_and_Right_Sum_Differences();
        Test.equal("Test 1", sol.leftRightDifference(new int[]{10,4,8,3}), new int[]{15,1,11,22});
        Test.equal("Test 2", sol.leftRightDifference(new int[]{1}), new int[]{0});
        Test.summary();
    }
}
