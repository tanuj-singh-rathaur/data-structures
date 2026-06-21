package graphs.topological;

import util.Test;

/**
 * Topological Sort via Kahn's BFS
 * Topic    : Graphs Topological
 * Pattern  : Enqueue indegree==0 nodes; pop and decrement neighbours' indegree
 * Difficulty: Medium
 * Source   : Classic CLRS
 */
public class P02_Topological_Sort_Kahn {
    public static void main(String[] args) {
        P02_Topological_Sort_Kahn sol = new P02_Topological_Sort_Kahn();
        Test.summary();
    }
}
