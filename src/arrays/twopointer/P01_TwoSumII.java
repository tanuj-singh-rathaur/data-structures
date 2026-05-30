package arrays.twopointer;

import util.Test;

/**
 *
 * Problem 1: Two Sum II - Input Array Is Sorted
 * 
 * LeetCode #167 | Difficulty: Easy
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Given a 1-indexed sorted array of integers and a target,
 * 
 * return the indices [i, j] of two numbers that add up to target.
 * 
 * Must use O(1) extra space. Exactly one solution guaranteed.
 *
 * 
 * 
 * Example:
 * 
 * Input: numbers = [2, 7, 11, 15], target = 9
 * 
 * Output: [1, 2] (numbers[1] + numbers[2] = 2 + 7 = 9)
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * The array is sorted. Think about what placing one pointer
 * 
 * at the start and one at the end tells you about the sum.
 * 
 * What should you do when the sum is too big? Too small?
 *
 * 
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 * 
 * YOUR ATTEMPT BELOW â€” delete this comment and write your solution
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 * 
 */

public class P01_TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target)
                return new int[] { left + 1, right + 1 };
            else if (sum < target)
                left++;
            else
                right--;
        }

        // TODO: write your solution here

        return new int[] { left, right };

    }

    // Quick test â€” run this file directly

    public static void main(String[] args) {

        P01_TwoSumII sol = new P01_TwoSumII();

        Test.equal("Test 1", sol.twoSum(new int[] { 2, 7, 11, 15 }, 9), new int[] { 1, 2 });
        Test.equal("Test 2", sol.twoSum(new int[] { 2, 3, 4 }, 6), new int[] { 1, 3 });
        Test.equal("Test 3", sol.twoSum(new int[] { -1, 0 }, -1), new int[] { 1, 2 });

        Test.summary();
    }

}
