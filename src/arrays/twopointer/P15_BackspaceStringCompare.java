package arrays.twopointer;

import util.Test;

/**

 * Problem 15: Backspace String Compare

 * LeetCode #844 | Difficulty: Easy

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 *

 * PROBLEM:

 *   Given two strings s and t where '#' means backspace, return true if

 *   the strings are equal after processing all backspaces.

 *   Solve in O(n) time and O(1) space (don't build the resulting strings).

 *

 * Example:

 *   s="ab#c",  t="ad#c"  â†’ true   (both become "ac")

 *   s="ab##",  t="c#d#"  â†’ true   (both become "")

 *   s="a#c",   t="b"     â†’ false  (sâ†’"c", tâ†’"b")

 *

 * PATTERN HINT:

 *   Process BOTH strings from right to left simultaneously.

 *   Keep a skip counter per string.

 *     - '#' seen â†’ increment skip (next real char will be deleted).

 *     - Non-'#' with skip > 0 â†’ decrement skip (this char is deleted).

 *     - Non-'#' with skip == 0 â†’ this is a real character to compare.

 *   Compare both strings' next real characters. If they differ â†’ false.

 *   If one string runs out before the other â†’ false.

 *

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 * YOUR ATTEMPT BELOW

 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

 */

public class P15_BackspaceStringCompare {



    public boolean backspaceCompare(String s, String t) {

        // TODO: write your solution here

        return false;

    }



    public static void main(String[] args) {

        P15_BackspaceStringCompare sol = new P15_BackspaceStringCompare();

        Test.equal("Test 1", sol.backspaceCompare("ab#c", "ad#c"), true);
        Test.equal("Test 2", sol.backspaceCompare("ab##", "c#d#"), true);
        Test.equal("Test 3", sol.backspaceCompare("a#c", "b"), false);

        Test.summary();
    }

}

