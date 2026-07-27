package arrays.slidingwindow;

import java.util.Arrays;
import java.util.List;

import util.Test;

/**
 * Find All Anagrams in a String
 * Pattern : Sliding Window (fixed size, freq match)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * ─────────────────────────────────────────────
 * Return start indices of all substrings in s that are anagrams of p.
 */
public class P11_Find_All_Anagrams_in_a_String {

    public List<Integer> findAnagrams(String s, String p) {
        // TODO: implement
        return java.util.Collections.emptyList();
    }

    public static void main(String[] args) {
        P11_Find_All_Anagrams_in_a_String sol = new P11_Find_All_Anagrams_in_a_String();
        Test.equal("Test 1", sol.findAnagrams("cbaebabacd", "abc"), Arrays.asList(0, 6));
        Test.equal("Test 2", sol.findAnagrams("abab", "ab"), Arrays.asList(0, 1, 2));
        Test.equal("Test 3", sol.findAnagrams("aa", "bb"), java.util.Collections.<Integer>emptyList());
        Test.summary();
    }
}
