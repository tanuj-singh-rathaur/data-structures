package arrays.twopointer;

import util.Test;

/**
 *
 * Problem 4: Trapping Rain Water
 * 
 * LeetCode #42 | Difficulty: Hard
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Given an elevation map (array of heights), compute how much
 * 
 * water can be trapped after it rains.
 *
 * 
 * 
 * Example:
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 
 * Output: 6
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * Water at any position = min(tallest wall on left, tallest wall on right) -
 * height at that position.
 * 
 * Can you track the tallest wall seen so far from each side
 * 
 * without a separate pass? Which side's wall is the real bottleneck?
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

public class P04_TrappingRainWater {

    public int trap(int[] height) {

        // TODO: write your solution here
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, total = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    total += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    total += rightMax - height[right];
                right--;

            }

        }

        return total;

    }

    public static void main(String[] args) {

        P04_TrappingRainWater sol = new P04_TrappingRainWater();

        Test.equal("Test 1", sol.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }), 6);
        Test.equal("Test 2", sol.trap(new int[] { 4, 2, 0, 3, 2, 5 }), 9);

        Test.summary();
    }

}
