package dp.knapsack;
import util.Test;
/**
 * Largest Subarray Sum Divisible by K (knapsack-style remainder DP)
 * Topic    : DP Knapsack
 * Pattern  : dp[r] = max subset sum with sum % K == r
 * Difficulty: Medium
 * Source   : Classic
 */
public class P20_Largest_Sum_Divisible_K {
    public static void main(String[] args) {
        P20_Largest_Sum_Divisible_K sol = new P20_Largest_Sum_Divisible_K();
        Test.summary();
    }
}
