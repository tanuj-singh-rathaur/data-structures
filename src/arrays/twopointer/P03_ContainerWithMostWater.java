package arrays.twopointer;

import util.Test;

/**
 *
 * Problem 3: Container With Most Water
 * 
 * LeetCode #11 | Difficulty: Medium
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Given n vertical lines where height[i] is the height of line i,
 * 
 * find two lines that together with the x-axis forms a container
 * 
 * that holds the most water.
 *
 * 
 * 
 * Example:
 * 
 * Input: height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
 * 
 * Output: 49
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * Area = width * min(left height, right height).
 * 
 * You start with maximum possible width.
 * 
 * Which pointer should you move to have any chance of finding more water?
 * 
 * Moving the taller one â€” does that ever help?
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

public class P03_ContainerWithMostWater {

    public int maxArea(int[] height) {

        // TODO: write your solution here
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int h = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, h);
            if (height[left] < height[right])
                left++;
            else
                right--;

        }

        return max;

    }

    public static void main(String[] args) {

        P03_ContainerWithMostWater sol = new P03_ContainerWithMostWater();

        Test.equal("Test 1", sol.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }), 49);
        Test.equal("Test 2", sol.maxArea(new int[] { 1, 1 }), 1);

        Test.summary();
    }

}
