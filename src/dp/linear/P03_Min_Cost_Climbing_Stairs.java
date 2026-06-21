package dp.linear;
import util.Test;
/**
 * Min Cost Climbing Stairs
 * Topic    : DP Linear
 * Pattern  : dp[i] = cost[i] + min(dp[i-1], dp[i-2])
 * Difficulty: Easy
 * Source   : LC 746
 */
public class P03_Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
        P03_Min_Cost_Climbing_Stairs sol = new P03_Min_Cost_Climbing_Stairs();
        Test.summary();
    }
}
