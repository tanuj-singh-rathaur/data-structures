package arrays.kadane;

import util.Test;

/**
 * Jump Game II (minimum jumps)
 * Pattern : BFS-style level tracking
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/jump-game-ii/
 * ─────────────────────────────────────────────
 * Return the min number of jumps to reach the last index.
 * Track currentEnd (frontier of current jump) and farthest reachable.
 */
public class P12_Jump_Game_II {

    public int jump(int[] nums) {
        // TODO: implement
        return 0;
    }

    public static void main(String[] args) {
        P12_Jump_Game_II sol = new P12_Jump_Game_II();
        Test.equal("Test 1", sol.jump(new int[]{2,3,1,1,4}), 2);
        Test.equal("Test 2", sol.jump(new int[]{2,3,0,1,4}), 2);
        Test.equal("Test 3", sol.jump(new int[]{1}), 0);
        Test.summary();
    }
}
