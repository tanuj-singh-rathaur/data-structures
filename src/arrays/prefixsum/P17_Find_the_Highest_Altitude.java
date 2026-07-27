package arrays.prefixsum;

import util.Test;

/**
 * Find the Highest Altitude
 * Pattern : Running sum; track max along the way
 * Difficulty: Easy
 * LeetCode : https://leetcode.com/problems/find-the-highest-altitude/
 * ─────────────────────────────────────────────
 * gain[i] is net altitude change on leg i (starting at 0). Return the highest altitude reached.
 */
public class P17_Find_the_Highest_Altitude {

    public int largestAltitude(int[] gain) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P17_Find_the_Highest_Altitude sol = new P17_Find_the_Highest_Altitude();
        Test.equal("Test 1", sol.largestAltitude(new int[]{-5,1,5,0,-7}), 1);
        Test.equal("Test 2", sol.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}), 0);
        Test.summary();
    }
}
