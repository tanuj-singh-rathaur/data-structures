package arrays.twopointer;

import util.Test;

/**
 * 
 * Problem 10: Reverse String
 * 
 * LeetCode #344 | Difficulty: Easy
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Write a function that reverses a character array s in-place.
 * 
 * Use O(1) extra memory.
 *
 * 
 * 
 * Example:
 * 
 * Input: ['h','e','l','l','o']
 * 
 * Output: ['o','l','l','e','h']
 *
 * 
 * 
 * Input: ['H','a','n','n','a','h']
 * 
 * Output: ['h','a','n','n','a','H']
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * This is the most fundamental two-pointer problem.
 * 
 * Swap the first and last characters, then move both pointers
 * 
 * inward. Stop when they meet (or cross).
 * 
 * This exact loop is reused inside many harder problems.
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

public class P10_ReverseString {

    public void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    public void reverseString(char[] s) {

        // TODO: write your solution here
        int left = 0, right = s.length - 1;

        while (left < right) {
            swap(s, left++, right--);
        }

    }

    public static void main(String[] args) {

        P10_ReverseString sol = new P10_ReverseString();

        char[] a1 = { 'h', 'e', 'l', 'l', 'o' };
        sol.reverseString(a1);
        Test.equal("Test 1", a1, new char[] { 'o', 'l', 'l', 'e', 'h' });

        char[] a2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
        sol.reverseString(a2);
        Test.equal("Test 2", a2, new char[] { 'h', 'a', 'n', 'n', 'a', 'H' });

        Test.summary();
    }

}
