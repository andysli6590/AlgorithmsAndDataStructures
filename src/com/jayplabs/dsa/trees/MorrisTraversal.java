package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class MorrisTraversal {

    /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecssor*/

    public static void morrisTraversal(Node root) {
        if (root == null) return;

        Node current = root;
        Node pre;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecssor*/

                else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        morrisTraversal(root);
    }
}
