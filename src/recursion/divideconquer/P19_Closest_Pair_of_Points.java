package recursion.divideconquer;

import util.Test;

/**
 * Closest Pair of Points
 * Topic    : Recursion
 * Pattern  : Divide & Conquer (Sort by x, Recurse, Strip Around Mid)
 * Difficulty: Hard
 * Source   : CLRS / Geometry classic
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Given n points in 2D, find the minimum pairwise distance in O(n log n).
 *
 * PATTERN HINT:
 *   [Sort by x. Recurse halves. Check points within d of the split line, sorted by y, comparing to next 7]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P19_Closest_Pair_of_Points {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P19_Closest_Pair_of_Points sol = new P19_Closest_Pair_of_Points();

        // TODO: add test cases once you've implemented the method.

        Test.summary();
    }
}
