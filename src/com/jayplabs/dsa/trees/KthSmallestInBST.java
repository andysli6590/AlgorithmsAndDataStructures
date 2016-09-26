package com.jayplabs.dsa.trees;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */

import com.jayplabs.dsa.common.Node;

/**
K’th smallest element in BST using O(1) Extra Space
        Given a Binary Search Tree (BST) and a positive integer k, find the k’th smallest element in the Binary Search Tree.

 Approach:
 Morris Traversal - In this traversal, we first create links to Inorder successor and print the data using these links,
 and finally revert the changes to restore original tree
 */

public class KthSmallestInBST {
    public static int kSmallestUsingMorris(Node root, int k) {
        int count = 0;
        int kSmall = Integer.MIN_VALUE;
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                count++;
                if (count == k) {
                    kSmall = current.data;
                }
                current = current.right;
            } else {
                Node pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    count++;
                    if (count == k) {
                        kSmall = current.data;
                    }
                    current = current.right;
                }
            }
        }
        return kSmall;
    }

    public static void main(String args[]) {
        Node root1 = new Node(5);
        root1.left = new Node(1);
        root1.right = new Node(10);
        root1.left.left = new Node(0);
        root1.left.right = new Node(4);
        root1.right.left = new Node(7);
        root1.right.left.right = new Node(9);
        System.out.print(kSmallestUsingMorris(root1, 3));
    }
}
