package dp.grid;
import util.Test;
/**
 * Dungeon Game (min initial health)
 * Topic    : DP Grid
 * Pattern  : DP from bottom-right; dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - grid[i][j])
 * Difficulty: Hard
 * Source   : LC 174
 */
public class P07_Dungeon_Game {
    public static void main(String[] args) {
        P07_Dungeon_Game sol = new P07_Dungeon_Game();
        Test.summary();
    }
}
