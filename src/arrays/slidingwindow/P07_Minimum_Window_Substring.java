package arrays.slidingwindow;

import util.Test;

/**
 * Minimum Window Substring
 * Pattern : Sliding Window (need-count map)
 * Difficulty: Hard
 * LeetCode : https://leetcode.com/problems/minimum-window-substring/
 * ─────────────────────────────────────────────
 * Return the smallest substring of s that contains every char of t (multiset).
 * Empty string if impossible.
 */
public class P07_Minimum_Window_Substring {

    public String minWindow(String s, String t) {
        // TODO: implement
        return "";
    }

    public static void main(String[] args) {
        P07_Minimum_Window_Substring sol = new P07_Minimum_Window_Substring();
        Test.equal("Test 1", sol.minWindow("ADOBECODEBANC", "ABC"), "BANC");
        Test.equal("Test 2", sol.minWindow("a", "a"), "a");
        Test.equal("Test 3", sol.minWindow("a", "aa"), "");
        Test.summary();
    }
}
