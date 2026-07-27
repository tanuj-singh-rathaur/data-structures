package arrays.prefixsum;

import util.Test;

/**
 * Corporate Flight Bookings
 * Pattern : Difference array — bookings[i]=[l,r,seats]: diff[l−1]+=seats, diff[r]−=seats
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/corporate-flight-bookings/
 * ─────────────────────────────────────────────
 * Return an array of length n where answer[i] = seats booked for flight i+1.
 */
public class P14_Corporate_Flight_Bookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        // TODO: implement
        return new int[0];
    }

    public static void main(String[] args) {
        P14_Corporate_Flight_Bookings sol = new P14_Corporate_Flight_Bookings();
        Test.equal("Test 1", sol.corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}}, 5), new int[]{10,55,45,25,25});
        Test.equal("Test 2", sol.corpFlightBookings(new int[][]{{1,2,10},{2,2,15}}, 2), new int[]{10,25});
        Test.summary();
    }
}
