package hashmap.frequency;

import util.Test;

/**
 * Top K Frequent Elements
 * Topic    : HashMap
 * Pattern  : Frequency Map + Bucket Sort / Heap
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/top-k-frequent-elements/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/top-k-frequent-elements/
 *
 * PATTERN HINT:
 *   [Count frequencies; bucket sort by frequency in O(n); or min-heap of size k for O(n log k)]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P03_Top_K_Frequent_Elements {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P03_Top_K_Frequent_Elements sol = new P03_Top_K_Frequent_Elements();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.topKFrequent(new int[]{1,1,1,2,2,3}, 2), new int[]{1,2});

        Test.summary();
    }
}
