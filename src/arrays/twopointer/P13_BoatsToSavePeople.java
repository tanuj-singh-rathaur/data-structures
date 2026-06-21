package arrays.twopointer;

import java.util.Arrays;

import util.Test;

/**
 * 
 * Problem 13: Boats to Save People
 * 
 * LeetCode #881 | Difficulty: Medium
 * 
 * â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
 *
 * 
 * 
 * PROBLEM:
 * 
 * Each boat holds at most 2 people with boats weight <= limit.
 * 
 * Given an array people[] of weights, return the minimum number
 * 
 * of boats needed to rescue everyone.
 *
 * 
 * 
 * Example:
 * 
 * Input: people=[3,2,2,1], limit=3 â†’ 3
 * 
 * Input: people=[3,5,3,4], limit=5 â†’ 4
 *
 * 
 * 
 * PATTERN HINT:
 * 
 * Sort people by weight.
 * 
 * Greedy: always put the heaviest person in a boat.
 * 
 * Then check if the lightest remaining person can share.
 * 
 * If people[left] + people[right] <= limit â†’ pair them (left++).
 * 
 * The heavy person always gets a boat regardless (right--, boats++).
 * 
 * Why is this greedy optimal? If the lightest can't pair with
 * 
 * the heaviest, they can't pair with anyone heavier â€” so pairing
 * 
 * them later gains nothing.
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

public class P13_BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {

        // TODO: write your solution here
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int boats = 0;
        while (left <= right) {
            int sum = people[right] + people[left];
            if (sum > limit) {
                boats++;
                right--;
            } else if (sum <= limit) {
                boats++;
                left++;
                right--;
            }
        }
        return boats;

    }

    public static void main(String[] args) {

        P13_BoatsToSavePeople sol = new P13_BoatsToSavePeople();

        Test.equal("Test 1", sol.numRescueBoats(new int[] { 3, 2, 2, 1 }, 3), 3);
        Test.equal("Test 2", sol.numRescueBoats(new int[] { 3, 5, 3, 4 }, 5), 4);
        Test.equal("Test 3", sol.numRescueBoats(new int[] { 1, 2 }, 3), 1);

        Test.summary();
    }

}
