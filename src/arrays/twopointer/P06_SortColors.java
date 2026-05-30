package arrays.twopointer;

import util.Test;

/**
 * 
 * Problem 6: Sort Colors (Dutch National Flag)
 * 
 * LeetCode #75 | Difficulty: Medium
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Given an array with only values 0, 1, and 2 (representing
 * 
 * red, white, blue), sort them in-place in a single pass.
 * 
 * Do NOT use Arrays.sort().
 *
 * 
 * 
 * Example:
 * 
 * Input: nums = [2,0,2,1,1,0]
 * 
 * Output: [0,0,1,1,2,2]
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * Two pointers isn't enough here â€” you need three.
 * 
 * One boundary for where 0s end, one for where 2s start,
 * 
 * and a scanner in the middle.
 * 
 * What happens when your scanner finds a 2? A 0? A 1?
 * 
 * Be careful: after swapping a 2, why shouldn't you advance the scanner?
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

public class P06_SortColors {

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortColors(int[] nums) {

        int low = 0, high = nums.length - 1, mid = 0;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                mid++;
                low++;
            } else if (nums[mid] == 1)
                mid++;
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {

        P06_SortColors sol = new P06_SortColors();

        int[] a1 = { 2, 0, 2, 1, 1, 0 };
        sol.sortColors(a1);
        Test.equal("Test 1", a1, new int[] { 0, 0, 1, 1, 2, 2 });

        int[] a2 = { 2, 0, 1 };
        sol.sortColors(a2);
        Test.equal("Test 2", a2, new int[] { 0, 1, 2 });

        Test.summary();
    }

}
