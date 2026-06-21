package recursion.divideconquer;

import util.Test;

/**
 * Count Inversions
 * Topic    : Recursion
 * Pattern  : Divide & Conquer (Merge Sort Counting)
 * Difficulty: Medium
 * Source   : Classic / GFG
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Count pairs (i, j) with i < j and nums[i] > nums[j].
 *
 * PATTERN HINT:
 *   [Modified merge: when picking from right half, all remaining left-half elements form inversions]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P10_Count_Inversions {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P10_Count_Inversions sol = new P10_Count_Inversions();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.countInversions(new int[]{2,4,1,3,5}), 3L);

        Test.summary();
    }
}
