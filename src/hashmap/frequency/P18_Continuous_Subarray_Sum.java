package hashmap.frequency;

import util.Test;

/**
 * Continuous Subarray Sum
 * Topic    : HashMap
 * Pattern  : Prefix Sum Mod K → First-Index Map
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/continuous-subarray-sum/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/continuous-subarray-sum/
 *
 * PATTERN HINT:
 *   [map<prefixSum % k, earliestIndex>; if same remainder seen before with gap ≥ 2 → true]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P18_Continuous_Subarray_Sum {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P18_Continuous_Subarray_Sum sol = new P18_Continuous_Subarray_Sum();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.checkSubarraySum(new int[]{23,2,4,6,7}, 6), true);

        Test.summary();
    }
}
