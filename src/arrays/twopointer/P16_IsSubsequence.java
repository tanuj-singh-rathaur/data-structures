package arrays.twopointer;

import util.Test;

/**
 * 
 * Problem 16: Is Subsequence
 * 
 * LeetCode #392 | Difficulty: Easy
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Given strings s and t, return true if s is a subsequence of t.
 * 
 * A subsequence means all characters of s appear in t in the same
 * 
 * order, but not necessarily contiguously.
 *
 * 
 * 
 * Example:
 * 
 * s="ace", t="abcde" â†’ true (a_c_e)
 * 
 * s="aec", t="abcde" â†’ false (e comes after c in t, not before)
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * Two pointers on two different strings â€” same direction, different speeds.
 * 
 * i points into s (the short string), j scans t (the long string).
 * 
 * j always advances. i only advances when s[i] == t[j] (a match).
 * 
 * If i reaches the end of s, all characters were found â†’ true.
 * 
 * This is the simplest same-direction two-pointer there is.
 *
 * 
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 * 
 * YOUR ATTEMPT BELOW
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 * 
 */

public class P16_IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int i = 0, j = 0;

        while (i <= s.length() - 1 && j <= t.length() - 1) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else
                j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {

        P16_IsSubsequence sol = new P16_IsSubsequence();

        Test.equal("Test 1", sol.isSubsequence("ace", "abcde"), true);
        Test.equal("Test 2", sol.isSubsequence("aec", "abcde"), false);
        Test.equal("Test 3", sol.isSubsequence("", "ahbgdc"), true);
        Test.equal("Test 4", sol.isSubsequence("b", "abc"), true);

        Test.summary();
    }

}
