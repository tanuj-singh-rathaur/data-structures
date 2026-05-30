package arrays.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Test;

/**
 * 
 * Problem 2: 3Sum
 * 
 * LeetCode #15 | Difficulty: Medium
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Given an integer array, return all unique triplets [a, b, c]
 * 
 * such that a + b + c = 0. The result must not have duplicate triplets.
 *
 * 
 * 
 * Example:
 * 
 * Input: nums = [-1, 0, 1, 2, -1, -4]
 * 
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * Can you reduce this to multiple Two Sum problems?
 * 
 * What does sorting help you do here?
 * 
 * How do you avoid duplicate triplets?
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

public class P02_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        // TODO: write your solution here

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {

                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (sum < 0)
                    left++;
                else if (sum > 0)
                    right--;

            }

        }

        return res;

    }

    public static void main(String[] args) {

        P02_ThreeSum sol = new P02_ThreeSum();

        Test.equal("Test 1", sol.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }),
                Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)));
        Test.equal("Test 2", sol.threeSum(new int[] { 0, 1, 1 }), new ArrayList<>());
        Test.equal("Test 3", sol.threeSum(new int[] { 0, 0, 0 }), Arrays.asList(Arrays.asList(0, 0, 0)));

        Test.summary();
    }

}
