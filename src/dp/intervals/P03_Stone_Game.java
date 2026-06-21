package dp.intervals;
import util.Test;
/**
 * Stone Game (Minimax)
 * Topic    : DP Intervals
 * Pattern  : dp[i][j] = max stone diff Alice over Bob in [i..j]
 * Difficulty: Medium
 * Source   : LC 877
 */
public class P03_Stone_Game {
    public static void main(String[] args) {
        P03_Stone_Game sol = new P03_Stone_Game();
        Test.summary();
    }
}
