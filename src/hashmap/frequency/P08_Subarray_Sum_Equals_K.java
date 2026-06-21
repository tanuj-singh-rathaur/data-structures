package hashmap.frequency;

import util.Test;

/**
 * Subarray Sum Equals K
 * Topic    : HashMap
 * Pattern  : Prefix Sum Frequency Map
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/subarray-sum-equals-k/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * PATTERN HINT:
 *   [map<prefixSum, count>; for each i, count += map.get(prefix - k); update map]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P08_Subarray_Sum_Equals_K {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P08_Subarray_Sum_Equals_K sol = new P08_Subarray_Sum_Equals_K();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.subarraySum(new int[]{1,1,1}, 2), 2);

        Test.summary();
    }
}
