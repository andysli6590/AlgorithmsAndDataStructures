package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class BSTtoGreaterSumTree {

    // Recursive function to transform a BST to sum tree.
// This function traverses the tree in reverse inorder so
// that we have visited all greater key nodes of the currently
// visited node
    public static int sum = 0;
    public static void createSumTree(Node root) {

        // Base case
        if (root == null) return;

        // Recur for right subtree
        createSumTree(root.right);
        // Update sum
        sum += root.data;
        // Store old sum in current node
        root.data = sum - root.data;
        // Recur for left subtree
        createSumTree(root.left);
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String args[]) {
        Node root1 = new Node(11);
        root1.left = new Node(2);
        root1.right = new Node(29);
        root1.left.left = new Node(1);
        root1.left.right = new Node(7);
        root1.right.left = new Node(15);
        root1.right.right = new Node(40);
        root1.right.right.left = new Node(35);
        createSumTree(root1);
        inOrder(root1);
    }
}
