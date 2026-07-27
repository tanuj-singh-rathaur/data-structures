package arrays.slidingwindow;

import util.Test;

/**
 * Fruit Into Baskets
 * Pattern : Sliding Window (longest with ≤ 2 distinct values)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/fruit-into-baskets/
 * ─────────────────────────────────────────────
 * Two baskets, each holds one fruit type. Pick fruits from a starting tree
 * moving right until you must stop. Return the maximum fruits you can collect.
 */
public class P12_Fruit_Into_Baskets {

    public int totalFruit(int[] fruits) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P12_Fruit_Into_Baskets sol = new P12_Fruit_Into_Baskets();
        Test.equal("Test 1", sol.totalFruit(new int[]{1,2,1}), 3);
        Test.equal("Test 2", sol.totalFruit(new int[]{0,1,2,2}), 3);
        Test.equal("Test 3", sol.totalFruit(new int[]{1,2,3,2,2}), 4);
        Test.summary();
    }
}
