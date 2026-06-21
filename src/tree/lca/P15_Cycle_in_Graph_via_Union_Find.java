package tree.lca;

import util.Test;

/**
 * Redundant Connection (LCA via Union-Find)
 * Topic    : Tree / Union-Find
 * Pattern  : When adding edge u-v, find(u) == find(v) → cycle
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/redundant-connection/
 */
public class P15_Cycle_in_Graph_via_Union_Find {
    public static void main(String[] args) {
        P15_Cycle_in_Graph_via_Union_Find sol = new P15_Cycle_in_Graph_via_Union_Find();
        Test.summary();
    }
}
