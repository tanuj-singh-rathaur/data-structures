package graphs.topological;

import util.Test;

/**
 * Schedule Tasks with Dependencies and Durations
 * Topic    : Graphs Topological + Critical Path
 * Pattern  : Topo + dp[v] = duration[v] + max(dp[u]) over predecessors
 * Difficulty: Medium
 * Source   : Project scheduling classic
 */
public class P17_Schedule_Tasks_with_Dependencies {
    public static void main(String[] args) {
        P17_Schedule_Tasks_with_Dependencies sol = new P17_Schedule_Tasks_with_Dependencies();
        Test.summary();
    }
}
