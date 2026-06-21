package dp.grid;
import util.Test;
/**
 * Distinct Subsequences
 * Topic    : DP Grid
 * Pattern  : dp[i][j] = dp[i-1][j-1] + dp[i-1][j] if match, else dp[i-1][j]
 * Difficulty: Hard
 * Source   : LC 115
 */
public class P12_Distinct_Subsequences {
    public static void main(String[] args) {
        P12_Distinct_Subsequences sol = new P12_Distinct_Subsequences();
        Test.summary();
    }
}
