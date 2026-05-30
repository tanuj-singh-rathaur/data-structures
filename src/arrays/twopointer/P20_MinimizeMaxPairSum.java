package arrays.twopointer;

import util.Test;

/**

 * Problem 20: Minimize Maximum Pair Sum in Array

 * LeetCode #1877 | Difficulty: Medium

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 *

 * PROBLEM:

 *   The pair sum of two elements is their sum. Given nums with even length,

 *   pair all elements into n/2 pairs (each element in exactly one pair).

 *   Minimize the MAXIMUM pair sum. Return that minimum possible maximum.

 *

 * Example:

 *   Input:  [3,5,2,3]  â†’ 7

 *   Optimal pairs: (2,5)â†’7  and  (3,3)â†’6  â†’ max = 7

 *   (Any other pairing gives a higher max)

 *

 *   Input:  [3,5,4,2,4,6]  â†’ 8

 *   Optimal pairs: (2,6) (3,5) (4,4) â†’ max = 8

 *

 * PATTERN HINT:

 *   Sort, then pair smallest with largest, 2nd-smallest with 2nd-largest, etc.

 *   This greedy approach balances all pairs, preventing any single pair

 *   from getting two extreme values.

 *   Two pointers from both ends, track the max pair sum seen.

 *   Same core idea as Boats to Save People (P13) and the classic

 *   "minimize max, maximize min" greedy family.

 *

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 * YOUR ATTEMPT BELOW

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 */

public class P20_MinimizeMaxPairSum {



    public int minPairSum(int[] nums) {

        // TODO: write your solution here

        return 0;

    }



    public static void main(String[] args) {

        P20_MinimizeMaxPairSum sol = new P20_MinimizeMaxPairSum();

        Test.equal("Test 1", sol.minPairSum(new int[] { 3, 5, 2, 3 }), 7);
        Test.equal("Test 2", sol.minPairSum(new int[] { 3, 5, 4, 2, 4, 6 }), 8);
        Test.equal("Test 3", sol.minPairSum(new int[] { 4, 1, 5, 1, 3, 7 }), 8);

        Test.summary();
    }

}

