package arrays.twopointer;

import util.Test;

/**
 * 
 * Problem 8: Squares of a Sorted Array
 * 
 * LeetCode #977 | Difficulty: Easy
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Given an integer array sorted in non-decreasing order (may include
 * 
 * negatives), return an array of the squares of each number, also in
 * 
 * non-decreasing order. Do NOT just square and re-sort â€” aim for O(n).
 *
 * 
 * 
 * Example:
 * 
 * Input: [-4, -1, 0, 3, 10]
 * 
 * Output: [0, 1, 9, 16, 100]
 *
 * 
 * 
 * Input: [-7, -3, 2, 3, 11]
 * 
 * Output: [4, 9, 9, 49, 121]
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * After squaring, the largest values come from the two ENDS
 * 
 * (most-negative or most-positive). Use two pointers at both ends
 * 
 * and fill a result array from right to left (largest first).
 * 
 * Think: which end has the bigger absolute value?
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

public class P08_SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {

        // TODO: write your solution here
        int arr[] = new int[nums.length];

        int left = 0, right = nums.length - 1, pos = nums.length - 1;

        while (left <= right) {
            int lSq = nums[left] * nums[left];
            int rSq = nums[right] * nums[right];

            if (lSq > rSq) {
                arr[pos--] = lSq;
                left++;
            } else {
                arr[pos--] = rSq;
                right--;
            }
        }

        return arr;

    }

    public static void main(String[] args) {

        P08_SquaresOfSortedArray sol = new P08_SquaresOfSortedArray();

        Test.equal("Test 1", sol.sortedSquares(new int[] { -4, -1, 0, 3, 10 }), new int[] { 0, 1, 9, 16, 100 });
        Test.equal("Test 2", sol.sortedSquares(new int[] { -7, -3, 2, 3, 11 }), new int[] { 4, 9, 9, 49, 121 });
        Test.equal("Test 3", sol.sortedSquares(new int[] { -5, -3, -1 }), new int[] { 1, 9, 25 });

        Test.summary();
    }

}
