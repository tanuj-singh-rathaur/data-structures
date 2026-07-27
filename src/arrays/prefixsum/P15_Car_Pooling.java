package arrays.prefixsum;

import util.Test;

/**
 * Car Pooling
 * Pattern : Difference array on trip timeline; sweep and check capacity
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/car-pooling/
 * ─────────────────────────────────────────────
 * Given trips[i] = [numPassengers, from, to], return true iff you can complete
 * every trip without exceeding capacity.
 */
public class P15_Car_Pooling {

    public boolean carPooling(int[][] trips, int capacity) {
        // TODO: implement
        return false;
    }

    public static void main(String[] args) {
        P15_Car_Pooling sol = new P15_Car_Pooling();
        Test.equal("Test 1", sol.carPooling(new int[][]{{2,1,5},{3,3,7}}, 4), false);
        Test.equal("Test 2", sol.carPooling(new int[][]{{2,1,5},{3,3,7}}, 5), true);
        Test.equal("Test 3", sol.carPooling(new int[][]{{2,1,5},{3,5,7}}, 3), true);
        Test.summary();
    }
}
