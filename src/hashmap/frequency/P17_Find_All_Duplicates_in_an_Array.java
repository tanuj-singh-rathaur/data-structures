package hashmap.frequency;

import util.Test;

/**
 * Find All Duplicates in an Array
 * Topic    : HashMap
 * Pattern  : Frequency Map (or In-Place Negation)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/find-all-duplicates-in-an-array/
 *
 * PATTERN HINT:
 *   [HashMap count; or O(1) extra space: negate nums[abs(x)-1]; second visit ⇒ duplicate]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P17_Find_All_Duplicates_in_an_Array {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P17_Find_All_Duplicates_in_an_Array sol = new P17_Find_All_Duplicates_in_an_Array();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.findDuplicates(new int[]{4,3,2,7,8,2,3,1}).toString(), "[2, 3]");

        Test.summary();
    }
}
