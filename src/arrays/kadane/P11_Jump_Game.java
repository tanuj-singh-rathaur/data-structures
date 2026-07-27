package arrays.kadane;

import util.Test;

/**
 * Jump Game (reachability)
 * Pattern : Greedy running-max reach
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/jump-game/
 * ─────────────────────────────────────────────
 * Return true if you can reach the last index starting from index 0.
 */
public class P11_Jump_Game {

    public boolean canJump(int[] nums) {
        // TODO: implement
        return false;
    }

    public static void main(String[] args) {
        P11_Jump_Game sol = new P11_Jump_Game();
        Test.equal("Test 1", sol.canJump(new int[]{2,3,1,1,4}), true);
        Test.equal("Test 2", sol.canJump(new int[]{3,2,1,0,4}), false);
        Test.equal("Test 3", sol.canJump(new int[]{0}), true);
        Test.summary();
    }
}
