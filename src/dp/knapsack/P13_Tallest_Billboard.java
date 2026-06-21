package dp.knapsack;
import util.Test;
/**
 * Tallest Billboard
 * Topic    : DP Knapsack
 * Pattern  : dp[diff] = max smaller-pile height; transitions add to left/right/skip
 * Difficulty: Hard
 * Source   : LC 956
 */
public class P13_Tallest_Billboard {
    public static void main(String[] args) {
        P13_Tallest_Billboard sol = new P13_Tallest_Billboard();
        Test.summary();
    }
}
