package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

import java.util.Stack;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class TreeTraversals {

    public static void inorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        while(true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) return;

            root = stack.pop();
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    public static void preorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        while(true) {
            while (root != null) {
                System.out.print(root.data + " ");
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) return;

            root = stack.pop();
            root = root.right;
        }
    }

    public static void postorderIterative(Node root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.add(root);
        while (!s1.isEmpty()) {
            Node temp = s1.pop();
            s2.push(temp);

            if (temp.left != null) s1.push(temp.left);

            if (temp.right != null) s1.push(temp.right);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().data + " ");
        }
    }

    public static void postorderRecursive(Node root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void preorderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);

        }
    }

    public static void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);

        }
    }





    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.print("Inorder Iterative: ");
        inorderIterative(root);
        System.out.print("\nInorder Recursive: ");
        inorderRecursive(root);
        System.out.print("\nPreorder Iterative: ");
        preorderIterative(root);
        System.out.print("\nPreorder Recursive: ");
        preorderRecursive(root);
        System.out.print("\nPost Order Iterative: ");
        postorderIterative(root);
        System.out.print("\nPost Order Recursive: ");
        postorderRecursive(root);
    }
}
