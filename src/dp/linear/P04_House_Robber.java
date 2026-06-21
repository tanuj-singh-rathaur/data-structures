package dp.linear;
import util.Test;
/**
 * House Robber
 * Topic    : DP Linear
 * Pattern  : dp[i] = max(dp[i-1], dp[i-2] + nums[i])
 * Difficulty: Medium
 * Source   : LC 198
 */
public class P04_House_Robber {
    public static void main(String[] args) {
        P04_House_Robber sol = new P04_House_Robber();
        Test.summary();
    }
}
