package binarysearch.onanswers;

import util.Test;

/**
 * Painter's Partition Problem
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers (same skeleton as Split Array Largest Sum / Allocate Pages)
 * Difficulty: Hard
 * Source   : GFG classic
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   k painters, n boards (lengths). Each painter paints contiguous boards. Minimize max time given speed 1.
 *
 * PATTERN HINT:
 *   [BS time in [max(boards), sum(boards)]; predicate: painters-needed(time) <= k]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P19_Painters_Partition_Problem {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P19_Painters_Partition_Problem sol = new P19_Painters_Partition_Problem();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.minTime(new int[]{10,20,30,40}, 2), 60);

        Test.summary();
    }
}
