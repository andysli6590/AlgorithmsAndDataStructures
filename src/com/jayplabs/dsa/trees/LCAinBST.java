package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class LCAinBST {

    /* Function to find LCA of n1 and n2. The function assumes that both
   n1 and n2 are present in BST */
    public static Node lca(Node root, int n1, int n2) {
        if (root == null) return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (n1 < root.data && n2 < root.data)
            return lca(root.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (n1 > root.data && n2 > root.data)
            return lca(root.right, n1, n2);

        return root;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Node lca = lca(root, 10, 14);
        System.out.println("LCA of 10 & 14 : " + lca.data);
    }
}
