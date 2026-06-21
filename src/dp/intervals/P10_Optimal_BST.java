package dp.intervals;
import util.Test;
/**
 * Optimal Binary Search Tree
 * Topic    : DP Intervals
 * Pattern  : dp[i][j] = min over root r of dp[i][r-1] + dp[r+1][j] + sum(freq[i..j])
 * Difficulty: Hard
 * Source   : Classic
 */
public class P10_Optimal_BST {
    public static void main(String[] args) {
        P10_Optimal_BST sol = new P10_Optimal_BST();
        Test.summary();
    }
}
