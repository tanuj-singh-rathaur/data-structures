package arrays.twopointer;

import util.Test;

/**
 * 
 * Problem 7: Move Zeroes
 * 
 * LeetCode #283 | Difficulty: Easy
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Given an integer array nums, move all 0s to the end
 * 
 * while maintaining the relative order of non-zero elements.
 * 
 * Do it in-place (no extra array).
 *
 * 
 * 
 * Example:
 * 
 * Input: [0, 1, 0, 3, 12]
 * 
 * Output: [1, 3, 12, 0, 0]
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * Same slow/fast template as Remove Duplicates (P05) and Remove Element (P17).
 * 
 * slow = "next write slot for a non-zero"
 * 
 * fast = scanner
 * 
 * When does slow advance?
 * 
 * What do you fill in after fast is done?
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

public class P07_MoveZeroes {

    public void moveZeroes(int[] nums) {

        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0)
                nums[slow++] = nums[fast];
        }

        while (slow < nums.length)
            nums[slow++] = 0;

    }

    public static void main(String[] args) {

        P07_MoveZeroes sol = new P07_MoveZeroes();

        int[] a1 = { 0, 1, 0, 3, 12 };
        sol.moveZeroes(a1);
        Test.equal("Test 1", a1, new int[] { 1, 3, 12, 0, 0 });

        int[] a2 = { 0 };
        sol.moveZeroes(a2);
        Test.equal("Test 2", a2, new int[] { 0 });

        int[] a3 = { 1, 2, 3 };
        sol.moveZeroes(a3);
        Test.equal("Test 3", a3, new int[] { 1, 2, 3 });

        Test.summary();
    }

}
