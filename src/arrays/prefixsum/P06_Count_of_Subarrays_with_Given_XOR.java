package arrays.prefixsum;

import util.Test;

/**
 * Count of Subarrays with Given XOR
 * Pattern : Prefix XOR + HashMap
 * Difficulty: Medium
 * ─────────────────────────────────────────────
 * Return the number of contiguous subarrays with XOR == m.
 * If prefixXor[j] ^ prefixXor[i] == m, then subarray (i+1..j) has XOR m,
 * i.e., look for prefixXor[i] == prefixXor[j] ^ m.
 */
public class P06_Count_of_Subarrays_with_Given_XOR {

    public int subarraysWithGivenXor(int[] nums, int m) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P06_Count_of_Subarrays_with_Given_XOR sol = new P06_Count_of_Subarrays_with_Given_XOR();
        Test.equal("Test 1", sol.subarraysWithGivenXor(new int[]{4,2,2,6,4}, 6), 4);
        Test.equal("Test 2", sol.subarraysWithGivenXor(new int[]{5,6,7,8,9}, 5), 2);
        Test.summary();
    }
}
