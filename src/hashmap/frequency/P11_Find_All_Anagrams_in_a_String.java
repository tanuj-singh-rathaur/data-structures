package hashmap.frequency;

import util.Test;

/**
 * Find All Anagrams in a String
 * Topic    : HashMap
 * Pattern  : Sliding Window + Frequency Count Compare
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 * PATTERN HINT:
 *   [Fixed-size sliding window of |p|. Maintain int[26] count; compare with p's count]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P11_Find_All_Anagrams_in_a_String {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P11_Find_All_Anagrams_in_a_String sol = new P11_Find_All_Anagrams_in_a_String();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.findAnagrams("cbaebabacd", "abc").toString(), "[0, 6]");

        Test.summary();
    }
}
