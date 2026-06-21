package dp.knapsack;
import util.Test;
/**
 * Best Sightseeing Pair
 * Topic    : DP Knapsack-style (single-pass max)
 * Pattern  : Track best (values[i] + i); answer = max over j of best + values[j] - j
 * Difficulty: Medium
 * Source   : LC 1014
 */
public class P16_Best_Sightseeing_Pair {
    public static void main(String[] args) {
        P16_Best_Sightseeing_Pair sol = new P16_Best_Sightseeing_Pair();
        Test.summary();
    }
}
