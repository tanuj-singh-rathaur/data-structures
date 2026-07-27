package arrays.slidingwindow;

import util.Test;

/**
 * Longest Substring Without Repeating Characters
 * Pattern : Sliding Window (unique-char set / map)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * ─────────────────────────────────────────────
 * Return length of the longest substring with all distinct characters.
 */
public class P09_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P09_Longest_Substring_Without_Repeating_Characters sol = new P09_Longest_Substring_Without_Repeating_Characters();
        Test.equal("Test 1", sol.lengthOfLongestSubstring("abcabcbb"), 3);
        Test.equal("Test 2", sol.lengthOfLongestSubstring("bbbbb"), 1);
        Test.equal("Test 3", sol.lengthOfLongestSubstring("pwwkew"), 3);
        Test.equal("Test 4", sol.lengthOfLongestSubstring(""), 0);
        Test.summary();
    }
}
