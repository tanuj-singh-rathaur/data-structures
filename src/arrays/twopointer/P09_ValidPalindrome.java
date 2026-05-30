package arrays.twopointer;

import util.Test;

/**
 * 
 * Problem 9: Valid Palindrome
 * 
 * LeetCode #125 | Difficulty: Easy
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * A phrase is a palindrome if it reads the same forward and backward
 * 
 * after converting uppercase to lowercase and removing all
 * 
 * non-alphanumeric characters.
 * 
 * Return true if s is a palindrome, false otherwise.
 *
 * 
 * 
 * Example:
 * 
 * Input: "A man, a plan, a canal: Panama" â†’ true (amanaplanacanalpanama)
 * 
 * Input: "race a car" â†’ false (raceacar)
 * 
 * Input: " " â†’ true (empty after cleanup)
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * Two pointers from both ends toward the middle.
 * 
 * Skip characters that are not letters or digits.
 * 
 * Compare case-insensitively.
 * 
 * Useful Java methods: Character.isLetterOrDigit(), Character.toLowerCase()
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

public class P09_ValidPalindrome {

    public boolean isPalindrome(String s) {

        // TODO: write your solution here
        char[] str = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();

        int left = 0, right = str.length - 1;

        while (left <= right) {
            if (str[left++] != str[right--])
                return false;
        }

        return true;

    }

    public static void main(String[] args) {

        P09_ValidPalindrome sol = new P09_ValidPalindrome();

        Test.equal("Test 1", sol.isPalindrome("A man, a plan, a canal: Panama"), true);
        Test.equal("Test 2", sol.isPalindrome("race a car"), false);
        Test.equal("Test 3", sol.isPalindrome(" "), true);

        Test.summary();
    }

}
