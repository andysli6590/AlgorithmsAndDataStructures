package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class DistanceBetweenNodes {

    public static int findDistance(Node root, Node n1, Node n2) {
        int x = findDistanceFromRoot(root, n1);
        int y = findDistanceFromRoot(root, n2);
        int lcaDistance = findDistanceFromRoot(root, getLCA(root, n1, n2));

        return (x+y) - 2 *(lcaDistance);
    }

    public static int findDistanceFromRoot(Node root, Node node) {
        if (root != null) {
            int x = -1;
            if (root.data == node.data || (x = findDistanceFromRoot(root.left, node)) > -1 || (x = findDistanceFromRoot(root.right, node)) > -1)
                return x+1;
        }
        return -1;
    }

    public static Node getLCA(Node root, Node n1, Node n2) {
        if (root == null) return null;

        if (root.data == n1.data || root.data == n2.data) return root;

        Node left = getLCA(root.left, n1, n2);
        Node right = getLCA(root.right, n1, n2);

        if (left != null && right != null) return root;

        if (left != null) return left;
        if (right != null) return right;

        return null;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        Node n2 = new Node(20);
        root.left.left = n2;
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        Node n1 = new Node(45);
        root.left.right.right = n1;

        System.out.println("Distance between 45 and 20 is : "
                + findDistance(root, n1, n2));
    }

}
