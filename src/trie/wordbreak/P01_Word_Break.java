package trie.wordbreak;

import util.Test;

/**
 * Word Break
 * Topic    : Trie / DP
 * Pattern  : Trie + dp[i] true iff s[0..i] segmentable
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/word-break/
 */
public class P01_Word_Break {
    public static void main(String[] args) {
        P01_Word_Break sol = new P01_Word_Break();
        Test.summary();
    }
}
