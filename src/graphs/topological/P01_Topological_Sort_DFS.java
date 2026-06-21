package graphs.topological;

import util.Test;

/**
 * Topological Sort via DFS
 * Topic    : Graphs Topological
 * Pattern  : DFS push to stack on finish; reverse gives topo order
 * Difficulty: Medium
 * Source   : Classic CLRS
 */
public class P01_Topological_Sort_DFS {
    public static void main(String[] args) {
        P01_Topological_Sort_DFS sol = new P01_Topological_Sort_DFS();
        Test.summary();
    }
}
