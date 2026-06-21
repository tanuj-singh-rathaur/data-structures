package dp.linear;
import util.Test;
/**
 * Longest Arithmetic Subsequence
 * Topic    : DP Linear (with state = (end, diff))
 * Pattern  : dp[i][diff] = 1 + dp[j][diff] for j < i
 * Difficulty: Medium
 * Source   : LC 1027
 */
public class P19_Longest_Arithmetic_Subseq {
    public static void main(String[] args) {
        P19_Longest_Arithmetic_Subseq sol = new P19_Longest_Arithmetic_Subseq();
        Test.summary();
    }
}
