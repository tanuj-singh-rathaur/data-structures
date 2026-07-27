package arrays.kadane;

import util.Test;

/**
 * Best Time to Buy and Sell Stock II (unlimited transactions)
 * Pattern : Sum of positive daily deltas
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * ─────────────────────────────────────────────
 * Greedily capture every up-day: profit += max(0, prices[i] − prices[i−1]).
 */
public class P06_Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P06_Best_Time_to_Buy_and_Sell_Stock_II sol = new P06_Best_Time_to_Buy_and_Sell_Stock_II();
        Test.equal("Test 1", sol.maxProfit(new int[]{7,1,5,3,6,4}), 7);
        Test.equal("Test 2", sol.maxProfit(new int[]{1,2,3,4,5}), 4);
        Test.equal("Test 3", sol.maxProfit(new int[]{7,6,4,3,1}), 0);
        Test.summary();
    }
}
