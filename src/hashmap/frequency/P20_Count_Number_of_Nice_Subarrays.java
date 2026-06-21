package hashmap.frequency;

import util.Test;

/**
 * Count Number of Nice Subarrays
 * Topic    : HashMap
 * Pattern  : Prefix Count of Odds → Frequency Map (or At-Most Window)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/count-number-of-nice-subarrays/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/count-number-of-nice-subarrays/
 *
 * PATTERN HINT:
 *   [Treat odd=1, even=0; prefix-sum frequency map: count += map.get(prefix - k)]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P20_Count_Number_of_Nice_Subarrays {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P20_Count_Number_of_Nice_Subarrays sol = new P20_Count_Number_of_Nice_Subarrays();

        // TODO: add test cases once you've implemented the method. Example:
        // Test.equal("Test 1",
        //     sol.numberOfSubarrays(new int[]{1,1,2,1,1}, 3), 2);

        Test.summary();
    }
}
