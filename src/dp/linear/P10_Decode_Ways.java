package dp.linear;
import util.Test;
/**
 * Decode Ways
 * Topic    : DP Linear
 * Pattern  : dp[i] = (valid 1-digit ? dp[i-1] : 0) + (valid 2-digit ? dp[i-2] : 0)
 * Difficulty: Medium
 * Source   : LC 91
 */
public class P10_Decode_Ways {
    public static void main(String[] args) {
        P10_Decode_Ways sol = new P10_Decode_Ways();
        Test.summary();
    }
}
