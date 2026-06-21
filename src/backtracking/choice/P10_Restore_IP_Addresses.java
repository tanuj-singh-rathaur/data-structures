package backtracking.choice;

import util.Test;

/**
 * Restore IP Addresses
 * Topic    : Backtracking
 * Pattern  : Choice-Based (Pick 1-3 Char Octets, Validate)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/restore-ip-addresses/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/restore-ip-addresses/
 *
 * PATTERN HINT:
 *   [4 segments × 1-3 chars; each octet 0..255; no leading zeros unless "0"]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P10_Restore_IP_Addresses {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P10_Restore_IP_Addresses sol = new P10_Restore_IP_Addresses();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.restoreIpAddresses("25525511135").size(), 2);

        Test.summary();
    }
}
