package arrays.twopointer;

import util.Test;

/**

 * Problem 17: Remove Element

 * LeetCode #27 | Difficulty: Easy

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 *

 * PROBLEM:

 *   Given an array nums and integer val, remove all occurrences of val

 *   in-place. Return the count of remaining elements.

 *   The order of remaining elements doesn't have to be preserved.

 *

 * Example:

 *   Input:  nums=[3,2,2,3], val=3   â†’ 2,  nums=[2,2,_,_]

 *   Input:  nums=[0,1,2,2,3,0,4,2], val=2 â†’ 5,  nums=[0,1,3,0,4,_,_,_]

 *

 * PATTERN HINT:

 *   Same slow/fast template as P05 and P07.

 *   slow = write cursor (next slot for a "good" element)

 *   fast = scanner

 *   Condition for writing: nums[fast] != val

 *   Compare with P05 (skip duplicate), P07 (skip zero) â€” only the

 *   rejection condition changes, the template is identical.

 *

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 * YOUR ATTEMPT BELOW

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 */

public class P17_RemoveElement {



    public int removeElement(int[] nums, int val) {

        // TODO: write your solution here

        return 0;

    }



    public static void main(String[] args) {

        P17_RemoveElement sol = new P17_RemoveElement();

        Test.equal("Test 1", sol.removeElement(new int[] { 3, 2, 2, 3 }, 3), 2);
        Test.equal("Test 2", sol.removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2), 5);
        Test.equal("Test 3", sol.removeElement(new int[] { 1 }, 1), 0);

        Test.summary();
    }

}

