package trie.bitwise;

import util.Test;

/**
 * Beautiful Arrangement (Bitmask DP)
 * Topic    : Bit Manipulation + DP
 * Pattern  : dp[mask] = ways to fill placed-count(mask) positions; iterate over set bits
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/beautiful-arrangement/
 */
public class P19_Beautiful_Arrangement_II_Bitmask {
    public static void main(String[] args) {
        P19_Beautiful_Arrangement_II_Bitmask sol = new P19_Beautiful_Arrangement_II_Bitmask();
        Test.summary();
    }
}
