package dp.knapsack;
import util.Test;
/**
 * Partition to K Equal Sum Subsets
 * Topic    : DP Knapsack (bitmask)
 * Pattern  : dp[mask] = remaining capacity when subset described by mask is used
 * Difficulty: Medium
 * Source   : LC 698
 */
public class P10_Partition_to_K_Equal_Subsets {
    public static void main(String[] args) {
        P10_Partition_to_K_Equal_Subsets sol = new P10_Partition_to_K_Equal_Subsets();
        Test.summary();
    }
}
