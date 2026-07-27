package arrays.slidingwindow;

import util.Test;

/**
 * Maximum Number of Vowels in a Substring of Given Length
 * Pattern : Sliding Window (fixed size, incremental count)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 * ─────────────────────────────────────────────
 * Return the max number of vowel letters in any substring of s of length k.
 */
public class P17_Maximum_Number_of_Vowels_in_Substring {

    public int maxVowels(String s, int k) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P17_Maximum_Number_of_Vowels_in_Substring sol = new P17_Maximum_Number_of_Vowels_in_Substring();
        Test.equal("Test 1", sol.maxVowels("abciiidef", 3), 3);
        Test.equal("Test 2", sol.maxVowels("aeiou", 2), 2);
        Test.equal("Test 3", sol.maxVowels("leetcode", 3), 2);
        Test.summary();
    }
}
