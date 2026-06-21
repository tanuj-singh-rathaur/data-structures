package backtracking.choice;

import util.Test;

/**
 * All Paths From Source to Target
 * Topic    : Backtracking
 * Pattern  : Choice-Based DFS (Pick Next Neighbour from Adjacency)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/all-paths-from-source-to-target/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * PATTERN HINT:
 *   [DFS from 0; at each node try every neighbour; record path on reaching n-1. DAG ⇒ no visited needed]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P20_All_Paths_from_Source_to_Target {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P20_All_Paths_from_Source_to_Target sol = new P20_All_Paths_from_Source_to_Target();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}).size(), 2);

        Test.summary();
    }
}
