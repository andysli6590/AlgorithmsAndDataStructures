package com.jayplabs.dsa.common;

/**
 * Created by Chandra Gopalaiah on 9/24/16.
 */
public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
