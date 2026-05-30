package arrays.twopointer;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Test;

/**

 * Problem 18: Find K Closest Elements

 * LeetCode #658 | Difficulty: Medium

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 *

 * PROBLEM:

 *   Given a sorted integer array arr, integer k, and integer x,

 *   return the k closest integers to x as a sorted list.

 *   Ties are broken by choosing the smaller element.

 *

 * Example:

 *   arr=[1,2,3,4,5], k=4, x=3  â†’ [1,2,3,4]

 *   arr=[1,2,3,4,5], k=4, x=-1 â†’ [1,2,3,4]

 *

 * PATTERN HINT:

 *   Think of it as finding the best WINDOW of k consecutive elements.

 *   The window's LEFT boundary ranges from 0 to arr.length-k.

 *   Binary search on this left boundary:

 *     - mid = (left + right) / 2

 *     - If distance from x to arr[mid] > distance from x to arr[mid+k],

 *       the window should shift right: left = mid + 1

 *     - Otherwise: right = mid

 *   When left==right, that's your window start. Return arr[left..left+k-1].

 *   Why arr.length-k as the upper bound? To ensure k elements always fit.

 *

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 * YOUR ATTEMPT BELOW

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 */

public class P18_FindKClosestElements {



    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        // TODO: write your solution here

        return new ArrayList<>();

    }



    public static void main(String[] args) {

        P18_FindKClosestElements sol = new P18_FindKClosestElements();

        Test.equal("Test 1", sol.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3),
                Arrays.asList(1, 2, 3, 4));
        Test.equal("Test 2", sol.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1),
                Arrays.asList(1, 2, 3, 4));
        Test.equal("Test 3", sol.findClosestElements(new int[] { 1, 3, 5, 7, 9 }, 3, 6),
                Arrays.asList(5, 7, 9));

        Test.summary();
    }

}

