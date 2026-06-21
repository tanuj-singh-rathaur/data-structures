package binarysearch.lowerupperbound;

import util.Test;

/**
 * Maximum Profit in Job Scheduling
 * Pattern : DP + Lower Bound on Next Compatible Job
 * Difficulty: Hard
 * LeetCode  : https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   [Read on LeetCode]
 *
 * PATTERN HINT:
 *   [Sort by end; dp[i] = max(skip = dp[i−1], take = profit[i] + dp[lowerBound(start[i])]); use BS]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P20_Maximum_Profit_in_Job_Scheduling {

    // TODO: define method signature after reading the problem

    public static void main(String[] args) {
        P20_Maximum_Profit_in_Job_Scheduling sol = new P20_Maximum_Profit_in_Job_Scheduling();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}), 120);

        Test.summary();
    }
}
