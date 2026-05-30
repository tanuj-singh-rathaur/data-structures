package arrays.twopointer;

import util.Test;

/**

 * Problem 19: Shortest Unsorted Continuous Subarray

 * LeetCode #581 | Difficulty: Medium

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 *

 * PROBLEM:

 *   Given an integer array nums, find the length of the shortest

 *   subarray that, if sorted, makes the entire array sorted.

 *   Return 0 if the array is already sorted.

 *

 * Example:

 *   Input:  [2,6,4,8,10,9,15]  â†’ 5  (sort [6,4,8,10,9])

 *   Input:  [1,2,3,4,5]        â†’ 0  (already sorted)

 *   Input:  [1]                â†’ 0

 *

 * PATTERN HINT:

 *   Two linear scans â€” one forward, one backward.

 *

 *   Forward scan (find right boundary):

 *     Keep a running max. Whenever nums[i] < runningMax,

 *     that element is out of place â†’ update rightBound = i.

 *

 *   Backward scan (find left boundary):

 *     Keep a running min. Whenever nums[i] > runningMin,

 *     that element is out of place â†’ update leftBound = i.

 *

 *   Answer = rightBound - leftBound + 1.

 *   Edge case: already sorted â†’ initialize right=-2, left=-1

 *   so right-left+1 = 0 automatically.

 *

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 * YOUR ATTEMPT BELOW

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 */

public class P19_ShortestUnsortedSubarray {



    public int findUnsortedSubarray(int[] nums) {

        // TODO: write your solution here

        return 0;

    }



    public static void main(String[] args) {

        P19_ShortestUnsortedSubarray sol = new P19_ShortestUnsortedSubarray();

        Test.equal("Test 1", sol.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }), 5);
        Test.equal("Test 2", sol.findUnsortedSubarray(new int[] { 1, 2, 3, 4, 5 }), 0);
        Test.equal("Test 3", sol.findUnsortedSubarray(new int[] { 1 }), 0);
        Test.equal("Test 4", sol.findUnsortedSubarray(new int[] { 3, 2, 1 }), 3);

        Test.summary();
    }

}

