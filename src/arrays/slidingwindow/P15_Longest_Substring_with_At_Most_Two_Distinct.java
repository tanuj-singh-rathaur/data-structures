package arrays.slidingwindow;

import util.Test;

/**
 * Longest Substring with At Most Two Distinct Characters
 * Pattern : Sliding Window (K=2 special case)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * ─────────────────────────────────────────────
 * Return the length of the longest substring with at most 2 distinct characters.
 */
public class P15_Longest_Substring_with_At_Most_Two_Distinct {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P15_Longest_Substring_with_At_Most_Two_Distinct sol = new P15_Longest_Substring_with_At_Most_Two_Distinct();
        Test.equal("Test 1", sol.lengthOfLongestSubstringTwoDistinct("eceba"), 3);
        Test.equal("Test 2", sol.lengthOfLongestSubstringTwoDistinct("ccaabbb"), 5);
        Test.summary();
    }
}
