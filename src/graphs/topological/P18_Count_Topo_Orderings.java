package graphs.topological;

import util.Test;

/**
 * Count All Topological Orderings of a DAG
 * Topic    : Graphs Topological
 * Pattern  : Bitmask DP — dp[mask] = ways to extend with one of the indegree-0 nodes
 * Difficulty: Hard
 * Source   : Classic combinatorial
 */
public class P18_Count_Topo_Orderings {
    public static void main(String[] args) {
        P18_Count_Topo_Orderings sol = new P18_Count_Topo_Orderings();
        Test.summary();
    }
}
