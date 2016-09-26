package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class DistanceToNodeFromRoot {
    public static int findDistance(Node root, int value) {
        if (root != null) {
            int x = -1;
            if (root.data == value || (x = findDistance(root.left, value)) > -1 || (x = findDistance(root.right, value)) > -1) {
                return x+1;
            }
            return -1;
        }
        return -1;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        root.left.right.right = new Node(45);
        System.out.println("Distance from root to 45 is : " + (findDistance(root, 45)));
    }
}
