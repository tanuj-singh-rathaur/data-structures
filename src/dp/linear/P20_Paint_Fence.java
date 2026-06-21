package dp.linear;
import util.Test;
/**
 * Paint Fence
 * Topic    : DP Linear
 * Pattern  : same[i] = diff[i-1]; diff[i] = (k-1)*(same[i-1] + diff[i-1])
 * Difficulty: Easy
 * Source   : LC 276
 */
public class P20_Paint_Fence {
    public static void main(String[] args) {
        P20_Paint_Fence sol = new P20_Paint_Fence();
        Test.summary();
    }
}
