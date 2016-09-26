package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class PrintLeftRightView {

    public static int currentLevel = 0;

    // PreOrder traversal
    public static void printLeftView(Node root, int nextLevel) {
        if (root != null) {
            if (currentLevel<nextLevel) {
                System.out.println(" " + root.data);
                currentLevel = nextLevel;
            }

            printLeftView(root.left, nextLevel+1);
            printLeftView(root.right, nextLevel+1);
        }
    }

    // Reverse preorder traversal would print right view of a tree
    public static void printRightView(Node root, int nextLevel) {
        if (root != null) {
            if (currentLevel<nextLevel) {
                System.out.println(" " + root.data);
                currentLevel = nextLevel;
            }
            printLeftView(root.right, nextLevel+1);
            printLeftView(root.left, nextLevel+1);

        }
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(1);
        root.left.left.left = new Node(9);
        root.left.left.right = new Node(2);
        root.left.left.right.right = new Node(7);
        root.right.right = new Node(0);
        root.right.right.left = new Node(8);

        printRightView(root, 1);
    }
}
