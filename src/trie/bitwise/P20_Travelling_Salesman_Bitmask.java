package trie.bitwise;

import util.Test;

/**
 * Travelling Salesman (Bitmask DP)
 * Topic    : Bit Manipulation + DP
 * Pattern  : dp[mask][i] = min cost visiting cities in mask ending at i
 * Difficulty: Hard
 * Source   : Classic TSP via bitmask
 */
public class P20_Travelling_Salesman_Bitmask {
    public static void main(String[] args) {
        P20_Travelling_Salesman_Bitmask sol = new P20_Travelling_Salesman_Bitmask();
        Test.summary();
    }
}
