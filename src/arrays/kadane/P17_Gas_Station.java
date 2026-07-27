package arrays.kadane;

import util.Test;

/**
 * Gas Station
 * Pattern : Greedy restart (Kadane-style)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/gas-station/
 * ─────────────────────────────────────────────
 * Return the starting index that lets you complete a circular trip.
 * If total(gas) &lt; total(cost) impossible. Otherwise the unique answer is the
 * first station after any tank-goes-negative point.
 */
public class P17_Gas_Station {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // TODO: implement
        return -1;
    }

    public static void main(String[] args) {
        P17_Gas_Station sol = new P17_Gas_Station();
        Test.equal("Test 1", sol.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}), 3);
        Test.equal("Test 2", sol.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}), -1);
        Test.summary();
    }
}
