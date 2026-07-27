package arrays.slidingwindow;

import util.Test;

/**
 * Permutation in String
 * Pattern : Sliding Window (fixed size, freq match)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/permutation-in-string/
 * ─────────────────────────────────────────────
 * Return true if s2 contains a permutation of s1.
 * Slide a window of size s1.length() over s2 and compare char counts.
 */
public class P10_Permutation_in_String {

    public boolean checkInclusion(String s1, String s2) {
        // TODO: implement
        return false;
    }

    public static void main(String[] args) {
        P10_Permutation_in_String sol = new P10_Permutation_in_String();
        Test.equal("Test 1", sol.checkInclusion("ab", "eidbaooo"), true);
        Test.equal("Test 2", sol.checkInclusion("ab", "eidboaoo"), false);
        Test.equal("Test 3", sol.checkInclusion("hello", "ooolleoooleh"), false);
        Test.summary();
    }
}
