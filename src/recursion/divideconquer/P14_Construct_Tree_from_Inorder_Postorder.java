package recursion.divideconquer;

import util.Test;

/**
 * Construct Binary Tree from Inorder and Postorder
 * Topic    : Recursion
 * Pattern  : Divide & Conquer on Inorder Split (Mirror of Preorder Variant)
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * PATTERN HINT:
 *   [Root = postorder[last]; find in inorder; right subtree comes BEFORE left in postorder]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P14_Construct_Tree_from_Inorder_Postorder {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P14_Construct_Tree_from_Inorder_Postorder sol = new P14_Construct_Tree_from_Inorder_Postorder();

        // TODO: add test cases once you've implemented the method.

        Test.summary();
    }
}
