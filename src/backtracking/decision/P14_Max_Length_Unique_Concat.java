package backtracking.decision;

import util.Test;

/**
 * Maximum Length of a Concatenated String with Unique Characters
 * Topic    : Backtracking + Bitmask
 * Pattern  : Decision Tree (include/skip each word; track used letters as bitmask)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class P14_Max_Length_Unique_Concat {

    public static void main(String[] args) {
        P14_Max_Length_Unique_Concat sol = new P14_Max_Length_Unique_Concat();
        Test.summary();
    }
}
