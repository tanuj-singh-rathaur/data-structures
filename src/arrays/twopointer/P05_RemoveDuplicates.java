package arrays.twopointer;

import util.Test;

/**
 *
 * Problem 5: Remove Duplicates from Sorted Array
 * 
 * LeetCode #26 | Difficulty: Easy
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Given a sorted array, remove duplicates in-place so each
 * 
 * element appears only once. Return the count of unique elements.
 * 
 * (Elements beyond that count don't matter.)
 *
 * 
 * 
 * Example:
 * 
 * Input: nums = [1, 1, 2]
 * 
 * Output: 2, nums = [1, 2, _]
 *
 * 
 * 
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * 
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * Think of two pointers: one that scans (fast) and one that
 * 
 * marks where the next unique element should be written (slow).
 * 
 * When does the slow pointer move?
 *
 * 
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 * 
 * YOUR ATTEMPT BELOW
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 * 
 */

public class P05_RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        // TODO: write your solution here
        if (nums.length == 0)
            return 0;
        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];

            }

        }

        return slow + 1;

    }

    public static void main(String[] args) {

        P05_RemoveDuplicates sol = new P05_RemoveDuplicates();

        Test.equal("Test 1", sol.removeDuplicates(new int[] { 1, 1, 2 }), 2);
        Test.equal("Test 2", sol.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }), 5);

        Test.summary();
    }

}
