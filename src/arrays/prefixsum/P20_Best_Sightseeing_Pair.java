package arrays.prefixsum;

import util.Test;

/**
 * Best Sightseeing Pair
 * Pattern : Score = (values[i] + i) + (values[j] − j); track best (values[i] + i) so far
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/best-sightseeing-pair/
 * ─────────────────────────────────────────────
 * Return the max score of any sightseeing pair (i &lt; j).
 */
public class P20_Best_Sightseeing_Pair {

    public int maxScoreSightseeingPair(int[] values) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P20_Best_Sightseeing_Pair sol = new P20_Best_Sightseeing_Pair();
        Test.equal("Test 1", sol.maxScoreSightseeingPair(new int[]{8,1,5,2,6}), 11);
        Test.equal("Test 2", sol.maxScoreSightseeingPair(new int[]{1,2}), 2);
        Test.summary();
    }
}
