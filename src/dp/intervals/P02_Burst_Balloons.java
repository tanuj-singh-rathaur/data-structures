package dp.intervals;
import util.Test;
/**
 * Burst Balloons
 * Topic    : DP Intervals
 * Pattern  : dp[i][j] = max over k of dp[i][k-1] + nums[i-1]*nums[k]*nums[j+1] + dp[k+1][j]
 * Difficulty: Hard
 * Source   : LC 312
 */
public class P02_Burst_Balloons {
    public static void main(String[] args) {
        P02_Burst_Balloons sol = new P02_Burst_Balloons();
        Test.summary();
    }
}
