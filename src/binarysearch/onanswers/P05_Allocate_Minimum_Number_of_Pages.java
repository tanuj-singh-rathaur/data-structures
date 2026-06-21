package binarysearch.onanswers;

import util.Test;

/**
 * Allocate Minimum Number of Pages
 * Topic    : Binary Search
 * Pattern  : Binary Search on Answers
 * Difficulty: Hard
 * Source   : Classic — books/students partition
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Allocate books to students minimizing the max pages assigned. Each student gets a contiguous range.
 *
 * PATTERN HINT:
 *   [BS pages-limit in [max(book), sum(book)]; predicate: students-needed(limit) <= k]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P05_Allocate_Minimum_Number_of_Pages {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P05_Allocate_Minimum_Number_of_Pages sol = new P05_Allocate_Minimum_Number_of_Pages();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.allocate(new int[]{12,34,67,90}, 2), 113);

        Test.summary();
    }
}
