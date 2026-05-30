package strings.slidingwindow;

import util.Test;

/**
 * Maximum Number of Occurrences of a Substring
 * Pattern : Sliding Window (Fixed minSize + Freq Map)
 * Difficulty: Medium
 * LeetCode  : https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read the problem on LeetCode]
 *
 * PATTERN HINT:
 *   [Only the minSize window matters — longer winners always contain a minSize winner;
 *    slide fixed minSize windows, count distinct chars, tally with a HashMap]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P20_Max_Number_of_Occurrences_of_Substring {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P20_Max_Number_of_Occurrences_of_Substring sol = new P20_Max_Number_of_Occurrences_of_Substring();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.maxFreq("aababcaab", 2, 3, 4), 2);

        Test.summary();
    }
}
