package dp.linear;
import util.Test;
/**
 * Word Break
 * Topic    : DP Linear
 * Pattern  : dp[i] true iff some j with dp[j] && s.substring(j,i) ∈ dict
 * Difficulty: Medium
 * Source   : LC 139
 */
public class P09_Word_Break {
    public static void main(String[] args) {
        P09_Word_Break sol = new P09_Word_Break();
        Test.summary();
    }
}
