package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

/**
 * Created by Chandra Gopalaiah on 9/26/16.
 */
public class CountBSTNodesInRange {

    public static int getCount(Node root, int low, int high) {
        if (root == null) return 0;

        // when the value is equal to both low & high, there's no need to traverse further.
        // This is purely for efficiency - No harm done if removed
        if (root.data == low && root.data == high)
            return 1;

        // If the node value is in range, then add 1 and traverse left and right child
        if (root.data >= low && root.data <= high)
            return 1+ getCount(root.left, low, high) + getCount(root.right, low, high);

        // If root value is greater than low, then traverse left child
        if (low < root.data)
            return getCount(root.left, low, high);
        else
            // if not traverse right child
            return getCount(root.right, low, high);
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(50);
        root.left.left = new Node(1);
        root.right.left = new Node(40);
        root.right.right = new Node(100);

        int low = 5;
        int high = 45;

        System.out.println("Count of nodes between [" + low + ", " + high + "] : " + getCount(root, low, high));

    }
}
