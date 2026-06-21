package hashmap.frequency;

import util.Test;

/**
 * Subarray Sums Divisible by K
 * Topic    : HashMap
 * Pattern  : Prefix Sum Mod K → Frequency Count
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/subarray-sums-divisible-by-k/
 *
 * PATTERN HINT:
 *   [map<(prefixSum % k + k) % k, count>; each match contributes C(c,2) pairs]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P19_Subarray_Sums_Divisible_by_K {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P19_Subarray_Sums_Divisible_by_K sol = new P19_Subarray_Sums_Divisible_by_K();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5), 7);

        Test.summary();
    }
}
