package dp.intervals;
import util.Test;
/**
 * Stone Game VII
 * Topic    : DP Intervals
 * Pattern  : dp[i][j] = max(sum(i+1..j) - dp[i+1][j], sum(i..j-1) - dp[i][j-1])
 * Difficulty: Medium
 * Source   : LC 1690
 */
public class P16_Stone_Game_VII {
    public static void main(String[] args) {
        P16_Stone_Game_VII sol = new P16_Stone_Game_VII();
        Test.summary();
    }
}
