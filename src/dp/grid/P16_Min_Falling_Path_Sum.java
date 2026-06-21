package dp.grid;
import util.Test;
/**
 * Minimum Falling Path Sum
 * Topic    : DP Grid
 * Pattern  : dp[i][j] = matrix[i][j] + min(dp[i-1][j-1..j+1])
 * Difficulty: Medium
 * Source   : LC 931
 */
public class P16_Min_Falling_Path_Sum {
    public static void main(String[] args) {
        P16_Min_Falling_Path_Sum sol = new P16_Min_Falling_Path_Sum();
        Test.summary();
    }
}
