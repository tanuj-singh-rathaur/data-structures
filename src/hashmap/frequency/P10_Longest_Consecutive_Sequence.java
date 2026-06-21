package hashmap.frequency;

import util.Test;

/**
 * Longest Consecutive Sequence
 * Topic    : HashMap (Set)
 * Pattern  : Set-based Sequence Walk
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/longest-consecutive-sequence/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * PATTERN HINT:
 *   [Put all nums in set; for each num that is sequence-start (num-1 not in set), walk + count]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P10_Longest_Consecutive_Sequence {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P10_Longest_Consecutive_Sequence sol = new P10_Longest_Consecutive_Sequence();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.longestConsecutive(new int[]{100,4,200,1,3,2}), 4);

        Test.summary();
    }
}
