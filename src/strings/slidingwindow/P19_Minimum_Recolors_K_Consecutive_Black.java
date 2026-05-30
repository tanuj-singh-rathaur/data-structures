package strings.slidingwindow;

import util.Test;

/**
 * Minimum Recolors to Get K Consecutive Black Blocks
 * Pattern : Sliding Window (Fixed K + White Counter)
 * Difficulty: Easy/Medium
 * LeetCode  : https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read the problem on LeetCode]
 *
 * PATTERN HINT:
 *   [Fixed K window; track # of W's; answer = min count over all windows]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P19_Minimum_Recolors_K_Consecutive_Black {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P19_Minimum_Recolors_K_Consecutive_Black sol = new P19_Minimum_Recolors_K_Consecutive_Black();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1", sol.minimumRecolors("WBBWWBBWBW", 7), 3);

        Test.summary();
    }
}
