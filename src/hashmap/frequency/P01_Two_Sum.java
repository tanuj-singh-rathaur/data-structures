package hashmap.frequency;

import util.Test;

/**
 * Two Sum
 * Topic    : HashMap
 * Pattern  : Index Map / Complement Lookup
 * Difficulty: Easy
 * LeetCode : https://leetcode.com/problems/two-sum/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/two-sum/
 *
 * PATTERN HINT:
 *   [Map value -> index; on each new num check map.containsKey(target - num)]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P01_Two_Sum {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P01_Two_Sum sol = new P01_Two_Sum();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.twoSum(new int[]{2,7,11,15}, 9), new int[]{0,1});

        Test.summary();
    }
}
