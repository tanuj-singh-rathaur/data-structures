package arrays.twopointer;

import util.Test;

/**

 * Problem 11: 3Sum Closest

 * LeetCode #16 | Difficulty: Medium

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 *

 * PROBLEM:

 *   Given an integer array nums and an integer target, find three integers

 *   whose sum is closest to target. Return that sum.

 *   Exactly one answer is guaranteed.

 *

 * Example:

 *   Input:  nums=[-1,2,1,-4], target=1

 *   Output: 2  (sum of -1+2+1 = 2, which is closest to 1)

 *

 * PATTERN HINT:

 *   This is 3Sum (P02) with one change: instead of checking sum==0,

 *   you track the closest sum seen so far.

 *   - Fix i (outer loop), run two-pointer on the rest.

 *   - Update your "closest" variable when |sum - target| is smaller.

 *   - Move pointers the same way: sum < target â†’ left++, sum > target â†’ right--.

 *   - If sum == target exactly, you can return immediately.

 *

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 * YOUR ATTEMPT BELOW

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 */

public class P11_ThreeSumClosest {



    public int threeSumClosest(int[] nums, int target) {

        // TODO: write your solution here

        return 0;

    }



    public static void main(String[] args) {

        P11_ThreeSumClosest sol = new P11_ThreeSumClosest();

        Test.equal("Test 1", sol.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1), 2);
        Test.equal("Test 2", sol.threeSumClosest(new int[] { 0, 0, 0 }, 1), 0);
        Test.equal("Test 3", sol.threeSumClosest(new int[] { 1, 1, 1, 0 }, -100), 2);

        Test.summary();
    }

}

