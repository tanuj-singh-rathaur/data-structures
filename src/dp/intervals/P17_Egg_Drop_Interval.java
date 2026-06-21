package dp.intervals;
import util.Test;
/**
 * Egg Drop (interval/minimax variant)
 * Topic    : DP Intervals
 * Pattern  : dp[k][n] = min moves to determine critical floor with k eggs and n floors
 * Difficulty: Hard
 * Source   : LC 887
 */
public class P17_Egg_Drop_Interval {
    public static void main(String[] args) {
        P17_Egg_Drop_Interval sol = new P17_Egg_Drop_Interval();
        Test.summary();
    }
}
