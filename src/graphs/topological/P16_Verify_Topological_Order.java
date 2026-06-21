package graphs.topological;

import util.Test;

/**
 * Verify Given Order is a Valid Topological Order
 * Topic    : Graphs Topological
 * Pattern  : Position map; check every edge u→v has pos[u] &lt; pos[v]
 * Difficulty: Easy
 * Source   : Classic
 */
public class P16_Verify_Topological_Order {
    public static void main(String[] args) {
        P16_Verify_Topological_Order sol = new P16_Verify_Topological_Order();
        Test.summary();
    }
}
