package com.jayplabs.dsa.common;

/**
 * Created by Chandra Gopalaiah on 9/24/16.
 */
public class DoubleListNode {
    int data;
    DoubleListNode prev;
    DoubleListNode next;
    public DoubleListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
