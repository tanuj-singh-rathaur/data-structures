package arrays.kadane;

import util.Test;

/**
 * Best Time to Buy and Sell Stock with Transaction Fee
 * Pattern : Two-state rolling DP (hold / cash)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * ─────────────────────────────────────────────
 * Unlimited transactions; each sell costs `fee`.
 */
public class P19_Best_Time_to_Buy_and_Sell_Stock_with_Fee {

    public int maxProfit(int[] prices, int fee) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P19_Best_Time_to_Buy_and_Sell_Stock_with_Fee sol = new P19_Best_Time_to_Buy_and_Sell_Stock_with_Fee();
        Test.equal("Test 1", sol.maxProfit(new int[]{1,3,2,8,4,9}, 2), 8);
        Test.equal("Test 2", sol.maxProfit(new int[]{1,3,7,5,10,3}, 3), 6);
        Test.summary();
    }
}
