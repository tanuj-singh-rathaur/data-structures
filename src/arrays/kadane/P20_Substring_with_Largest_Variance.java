package arrays.kadane;

import util.Test;

/**
 * Substring with Largest Variance
 * Pattern : Kadane per ordered (a, b) pair, with "has-b" flag
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/substring-with-largest-variance/
 * ─────────────────────────────────────────────
 * variance(substr) = maxFreq(char) − minFreq(char in substr). Return the
 * maximum variance across all substrings.
 */
public class P20_Substring_with_Largest_Variance {

    public int largestVariance(String s) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P20_Substring_with_Largest_Variance sol = new P20_Substring_with_Largest_Variance();
        Test.equal("Test 1", sol.largestVariance("aababbb"), 3);
        Test.equal("Test 2", sol.largestVariance("abcde"), 0);
        Test.summary();
    }
}
