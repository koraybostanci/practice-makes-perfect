package com.coding.practices.crackingthecodinginterview.chapter4_treesandgraphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */
public class P02_MinimalTree {

    class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    public TreeNode buildBinarySearchTree(final int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return buildBinarySearchTree(array, 0 , array.length - 1);
    }

    private TreeNode buildBinarySearchTree(final int[] array, final int startIndex, final int endIndex) {
        if (endIndex < startIndex) {
            return null;
        }

        final int midIndex = (startIndex + endIndex) / 2;
        final TreeNode node = new TreeNode(array[midIndex]);
        node.left = buildBinarySearchTree(array, startIndex, midIndex - 1);
        node.right = buildBinarySearchTree(array, midIndex + 1, endIndex);
        return node;
    }

    @Test
    void test() {
        final int[] array = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root = buildBinarySearchTree(array);

        assertNotNull(root);
        assertTrue(root.value == 5);
    }
}
