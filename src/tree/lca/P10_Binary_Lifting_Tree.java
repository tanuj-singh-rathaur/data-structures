package tree.lca;

import util.Test;

/**
 * LCA via Binary Lifting (offline / heavy queries)
 * Topic    : Tree LCA
 * Pattern  : Preprocess up[u][k] = 2^k-th ancestor; query O(log n)
 * Difficulty: Hard
 * Source   : Competitive programming classic
 */
public class P10_Binary_Lifting_Tree {
    public static void main(String[] args) {
        P10_Binary_Lifting_Tree sol = new P10_Binary_Lifting_Tree();
        Test.summary();
    }
}
