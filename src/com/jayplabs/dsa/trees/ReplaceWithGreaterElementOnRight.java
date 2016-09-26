package com.jayplabs.dsa.trees;

/**
 * Created by Chandra Gopalaiah on 9/24/16.
 */

import com.jayplabs.dsa.common.Node;

import java.util.Arrays;

/**
 * Given an array of integers, replace every element with the least greater element on its right side in the array.
 * If there are no greater element on right side, replace it with -1.
 *
 * Examples:
 * Input:   [8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28]
 * Output:  [18, 63, 80, 25, 32, 43, 80, 93, 80, 25, 93, -1, 28, -1, -1]
 *
 * Solution:
 * A naive method is to run two loops. The outer loop will one by one pick array elements from left to right.
 * The inner loop will find the smallest element greater than the picked element on its right side.
 * Finally the outer loop will replace the picked element with the element found by inner loop.
 * The time complexity of this method will be O(n2).
 *
 *
 * A tricky solution would be to use Binary Search Trees. We start scanning the array from right to left and insert
 * each element into the BST. For each inserted element, we replace it in the array by its inorder successor in BST.
 * If the element inserted is the maximum so far (i.e. its inorder successor doesn’t exists), we replace it by -1.
 *
 * Reference : http://www.geeksforgeeks.org/replace-every-element-with-the-least-greater-element-on-its-right/
 */

public class ReplaceWithGreaterElementOnRight {

    private Node root;
    private Node successor;

    public  void insert(Node root, int data) {
        if (data < root.data) {
            successor = root;
            if (root.left == null)
                root.left = new Node(data);
            else
                insert(root.left, data);
        } else if (data > root.data) {
            if (root.right == null)
                root.right = new Node(data);
            else
                insert(root.right, data);
        }
    }

    public int[] replace(int[] array) {
        root = new Node(array[array.length-1]);
        array[array.length-1] = -1;
        for (int i=array.length-2;i>=0;--i) {
            this.successor = null;
            insert(root, array[i]);
            if (successor != null)
                array[i] = successor.data;
            else
                array[i] = -1;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] input = {8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
        System.out.println("Input Array : " + Arrays.toString(input));
        ReplaceWithGreaterElementOnRight tree = new ReplaceWithGreaterElementOnRight();
        int[] output = tree.replace(input);

        System.out.println("Output Array : " + Arrays.toString(output));
    }


}
