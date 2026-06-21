package trie.bitwise;

import util.Test;

/**
 * Counting Bits
 * Topic    : Bit Manipulation / DP
 * Pattern  : dp[i] = dp[i &gt;&gt; 1] + (i &amp; 1)
 * Difficulty: Easy
 * LeetCode : https://leetcode.com/problems/counting-bits/
 */
public class P11_Counting_Bits {
    public static void main(String[] args) {
        P11_Counting_Bits sol = new P11_Counting_Bits();
        Test.summary();
    }
}
