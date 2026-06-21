package dp.intervals;
import util.Test;
/**
 * Matrix Chain Multiplication
 * Topic    : DP Intervals
 * Pattern  : dp[i][j] = min over k of dp[i][k] + dp[k+1][j] + cost
 * Difficulty: Medium
 * Source   : Classic
 */
public class P01_Matrix_Chain_Multiplication {
    public static void main(String[] args) {
        P01_Matrix_Chain_Multiplication sol = new P01_Matrix_Chain_Multiplication();
        Test.summary();
    }
}
