package arrays.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Test;

/**
 * 
 * Problem 12: 4Sum
 * 
 * LeetCode #18 | Difficulty: Medium
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Given integer array nums and integer target, return all unique
 * 
 * quadruplets [a,b,c,d] such that a+b+c+d == target.
 * 
 * No duplicate quadruplets in the result.
 *
 * 
 * 
 * Example:
 * 
 * Input: nums=[1,0,-1,0,-2,2], target=0
 * 
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * 4Sum = 3Sum + one more fixed loop.
 * 
 * - Sort the array.
 * 
 * - Fix i (skip dupes), fix j (skip dupes), then run Two Pointer inside.
 * 
 * - Deduplication: if nums[i]==nums[i-1] and i>0, skip i. Same for j.
 * 
 * - Watch out: sum of 4 ints can overflow int. Use long for the sum.
 * 
 * - k-Sum pattern: each level adds one fixed pointer + recurse / two-pointer.
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

public class P12_FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        // TODO: write your solution here
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1, right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (sum < target)
                        left++;
                    else
                        right--;
                }

            }
        }

        return res;

    }

    public static void main(String[] args) {

        P12_FourSum sol = new P12_FourSum();

        Test.equal("Test 1", sol.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0),
                Arrays.asList(
                        Arrays.asList(-2, -1, 1, 2),
                        Arrays.asList(-2, 0, 0, 2),
                        Arrays.asList(-1, 0, 0, 1)));
        Test.equal("Test 2", sol.fourSum(new int[] { 2, 2, 2, 2, 2 }, 8),
                Arrays.asList(Arrays.asList(2, 2, 2, 2)));
        Test.equal("Test 3", sol.fourSum(new int[] { 0, 0, 0, 0 }, 0),
                Arrays.asList(Arrays.asList(0, 0, 0, 0)));

        Test.summary();
    }

}
