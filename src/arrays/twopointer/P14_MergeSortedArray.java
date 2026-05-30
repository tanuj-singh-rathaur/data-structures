package arrays.twopointer;




import util.Test;

/**

 * Problem 14: Merge Sorted Array

 * LeetCode #88 | Difficulty: Easy

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 *

 * PROBLEM:

 *   nums1 has m valid elements followed by n zeros (pre-allocated space).

 *   nums2 has n elements.

 *   Merge nums2 into nums1 in sorted order, in-place.

 *

 * Example:

 *   nums1=[1,2,3,0,0,0], m=3,  nums2=[2,5,6], n=3

 *   After merge: nums1=[1,2,2,3,5,6]

 *

 * PATTERN HINT:

 *   If you fill from the FRONT you'll overwrite elements you still need.

 *   Fill from the BACK instead â€” the tail of nums1 is always free space.

 *   Three pointers: p1 starts at m-1, p2 at n-1, p (write pos) at m+n-1.

 *   Always write the LARGER of nums1[p1] / nums2[p2] at position p.

 *   After the loop: if p2 still has elements left, copy them over

 *   (if p1 runs out first). If p1 still has elements, they're already in place.

 *

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 * YOUR ATTEMPT BELOW

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 */

public class P14_MergeSortedArray {



    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // TODO: write your solution here

    }



    public static void main(String[] args) {

        P14_MergeSortedArray sol = new P14_MergeSortedArray();

        int[] a1 = { 1, 2, 3, 0, 0, 0 };
        sol.merge(a1, 3, new int[] { 2, 5, 6 }, 3);
        Test.equal("Test 1", a1, new int[] { 1, 2, 2, 3, 5, 6 });

        int[] a2 = { 1 };
        sol.merge(a2, 1, new int[] {}, 0);
        Test.equal("Test 2", a2, new int[] { 1 });

        int[] a3 = { 0 };
        sol.merge(a3, 0, new int[] { 1 }, 1);
        Test.equal("Test 3", a3, new int[] { 1 });

        Test.summary();
    }

}

