package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

/**
 * Created by Chandra Gopalaiah on 9/26/16.
 */
public class BSTCheck {

    public static boolean checkBSTInCorrect(Node root) {
        if (root != null) {
            Node left = root.left;
            Node right = root.right;


            if (left != null && left.data > root.data) return false;
            if (right != null && right.data < root.data) return false;

            return checkBSTInCorrect(left) && checkBSTInCorrect(right);
        }
        return false;
    }

    public static boolean checkBSTCorrect(Node root) {
        return checkBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean checkBSTUtil(Node root, int min, int max) {
        if (root == null) return true;

        if (root.data < min || root.data > max) return false;

        return (checkBSTUtil(root.left, min, root.data-1) &&
        checkBSTUtil(root.right, root.data+1, max));
    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.left = new Node(25);
        System.out.println(checkBSTInCorrect(root) ? "yes" : "no");
    }
}
