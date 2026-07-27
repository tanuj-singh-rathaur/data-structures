package arrays.slidingwindow;

import util.Test;

/**
 * Longest Substring with At Most K Distinct Characters
 * Pattern : Sliding Window (shrink when distinct > K)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * ─────────────────────────────────────────────
 * Return the length of the longest substring with at most K distinct characters.
 */
public class P14_Longest_Substring_with_At_Most_K_Distinct {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P14_Longest_Substring_with_At_Most_K_Distinct sol = new P14_Longest_Substring_with_At_Most_K_Distinct();
        Test.equal("Test 1", sol.lengthOfLongestSubstringKDistinct("eceba", 2), 3);
        Test.equal("Test 2", sol.lengthOfLongestSubstringKDistinct("aa", 1), 2);
        Test.equal("Test 3", sol.lengthOfLongestSubstringKDistinct("", 2), 0);
        Test.summary();
    }
}
