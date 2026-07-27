package arrays.kadane;

import util.Test;

/**
 * Best Time to Buy and Sell Stock with Cooldown
 * Pattern : Three-state rolling DP (hold / sold / rest)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * ─────────────────────────────────────────────
 * Unlimited transactions, but 1-day cooldown after each sell.
 */
public class P18_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    public int maxProfit(int[] prices) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P18_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown sol = new P18_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown();
        Test.equal("Test 1", sol.maxProfit(new int[]{1,2,3,0,2}), 3);
        Test.equal("Test 2", sol.maxProfit(new int[]{1}), 0);
        Test.equal("Test 3", sol.maxProfit(new int[]{1,2,4}), 3);
        Test.summary();
    }
}
