package recursion.divideconquer;

import util.Test;

/**
 * Construct Binary Tree from Preorder and Inorder
 * Topic    : Recursion
 * Pattern  : Divide & Conquer on Inorder Split
 * Difficulty: Medium
 * LeetCode : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * ─────────────────────────────────────────────
 *
 * PROBLEM:
 *   Read on LeetCode: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * PATTERN HINT:
 *   [Root = preorder[0]; find in inorder; left = elements before, right = after; recurse on each]
 *
 * ─────────────────────────────────────────────
 * YOUR ATTEMPT BELOW
 * ─────────────────────────────────────────────
 */
public class P13_Construct_Tree_from_Preorder_Inorder {

    // TODO: define your method signature after reading the problem

    public static void main(String[] args) {
        P13_Construct_Tree_from_Preorder_Inorder sol = new P13_Construct_Tree_from_Preorder_Inorder();

        // TODO: add test cases once you've implemented the method.

        Test.summary();
    }
}
