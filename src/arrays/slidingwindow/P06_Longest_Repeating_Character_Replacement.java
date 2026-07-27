package arrays.slidingwindow;

import util.Test;

/**
 * Longest Repeating Character Replacement
 * Pattern : Sliding Window (max-freq char in window)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/longest-repeating-character-replacement/
 * ─────────────────────────────────────────────
 * Return length of longest substring where you can replace at most k chars to
 * make all chars equal. Shrink when (windowLen - maxFreq) > k.
 */
public class P06_Longest_Repeating_Character_Replacement {

    public int characterReplacement(String s, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P06_Longest_Repeating_Character_Replacement sol = new P06_Longest_Repeating_Character_Replacement();
        Test.equal("Test 1", sol.characterReplacement("ABAB", 2), 4);
        Test.equal("Test 2", sol.characterReplacement("AABABBA", 1), 4);
        Test.summary();
    }
}
