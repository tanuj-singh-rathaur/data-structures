package graphs.dfs;

import util.Test;

/**
 * Longest Path in a DAG
 * Topic    : Graphs DFS / DP
 * Pattern  : Memoised DFS — longest[v] = 1 + max(longest[u]) over outgoing edges
 * Difficulty: Medium
 * Source   : Classic
 */
public class P20_Longest_Path_in_DAG {
    public static void main(String[] args) {
        P20_Longest_Path_in_DAG sol = new P20_Longest_Path_in_DAG();
        Test.summary();
    }
}
