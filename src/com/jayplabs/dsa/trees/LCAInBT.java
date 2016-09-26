package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class LCAInBT {
    public static Node getLca(Node root, Node n1, Node n2) {
        if (root == null) return null;

        if (root.data == n1.data || root.data == n2.data) return root;

        Node left = getLca(root.left, n1, n2);
        Node right = getLca(root.right, n1, n2);

        if (left != null && right != null) return root;

        if (left != null) return left;
        else if (right != null) return right;

        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        Node n3 = new Node(5);
        root.left.right = n3;
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node n1 = new Node(8);
        root.left.left.left = n1;
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(20);

        root.left.right.left.left = new Node(11);
        Node n2 = new Node(30);
        root.left.right.left.right = n2;

        Node x = getLca(root, n1, n2);
        System.out.println("Lowest Common Ancestor (" + n1.data + ", " + n2.data + " ) is " + x.data);

        x = getLca(root,n2,n3);
        System.out.println("Lowest Common Ancestor ("+n2.data+", "+ n3.data +" ) is " + x.data);

    }
}
