package arrays.kadane;

import util.Test;

/**
 * Best Time to Buy and Sell Stock (single transaction)
 * Pattern : Kadane on price-differences
 * Difficulty: Easy
 * LeetCode : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * ─────────────────────────────────────────────
 * Return the max profit from ONE buy + ONE sell (buy before sell).
 * Track min-so-far; best = max(best, price − min).
 */
public class P02_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P02_Best_Time_to_Buy_and_Sell_Stock sol = new P02_Best_Time_to_Buy_and_Sell_Stock();
        Test.equal("Test 1", sol.maxProfit(new int[]{7,1,5,3,6,4}), 5);
        Test.equal("Test 2", sol.maxProfit(new int[]{7,6,4,3,1}), 0);
        Test.equal("Test 3", sol.maxProfit(new int[]{1,2}), 1);
        Test.summary();
    }
}
