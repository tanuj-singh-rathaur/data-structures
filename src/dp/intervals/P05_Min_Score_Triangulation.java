package dp.intervals;
import util.Test;
/**
 * Minimum Score Triangulation of Polygon
 * Topic    : DP Intervals
 * Pattern  : dp[i][j] = min over k of dp[i][k] + dp[k][j] + v[i]*v[k]*v[j]
 * Difficulty: Medium
 * Source   : LC 1039
 */
public class P05_Min_Score_Triangulation {
    public static void main(String[] args) {
        P05_Min_Score_Triangulation sol = new P05_Min_Score_Triangulation();
        Test.summary();
    }
}
