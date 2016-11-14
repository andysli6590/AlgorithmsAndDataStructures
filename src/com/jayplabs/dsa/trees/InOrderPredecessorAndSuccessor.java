package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

/**
 * Created by Chandra Gopalaiah on 9/26/16.
 */

//Objec­tive: - Given a Binary Search Tree, Find pre­de­ces­sor and Suc­ces­sor of a given node.

public class InOrderPredecessorAndSuccessor {

    static int successor, predecessor;
    public static void successorPredecessor(Node root, int key) {
        if (root != null) {
            if (root.data == key) {
                if (root.left != null) {
                    // go to the right most element in the left subtree, it will the
                    // predecessor.
                    Node temp = root.left;
                    while (temp.right != null) temp = temp.right;
                    predecessor = temp.data;
                }
                if (root.right != null) {
                    // go to the left most element in the right subtree, it will
                    // the successor.
                    Node temp = root.right;
                    while (temp.left != null) temp = temp.left;
                    successor = temp.data;
                }
            }
            if (key > root.data) {
                // we make the root as predecessor because we might have a
                // situation when value matches with the root, it wont have
                // right subtree to find the predecessor, in that case we need
                // parent to be the predecessor.
                predecessor = root.data;
                successorPredecessor(root.right, key);
            } else {
                // we make the root as successor because we might have a
                // situation when value matches with the root, it wont have
                // right subtree to find the successor, in that case we need
                // parent to be the successor
                successor = root.data;
                successorPredecessor(root.left, key);
            }
        }
    }

    public static void main(String args[]) {
        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.left.right = new Node(7);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(35);
        root.left.right.left = new Node(13);
        root.left.right.right = new Node(18);
        successorPredecessor(root, 10);
        System.out.println("Inorder Successor of 10 is : " + successor
                + " and predecessor is : " + predecessor);
        successorPredecessor(root, 30);
        System.out.println("Inorder Successor of 30 is : " + successor
                + " and predecessor is : " + predecessor);
    }
}
