package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class VerticalSum {
    static HashMap<Integer, Integer> hd = new HashMap<>();

    // Inorder traversal, maintain the column index for every sum stored and keep adding to existing sum
    public static void verticalSum(Node root, int level) {
        if (root == null) return;

        verticalSum(root.left, level-1);
        int prevSum = (hd.containsKey(level) ? hd.get(level) : 0);
        hd.put(level, prevSum+root.data);
        verticalSum(root.right, level+1);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        root.left.right.left = new Node(40);
        root.left.right.right = new Node(45);
        root.left.right.left.left = new Node(50);

        verticalSum(root, 0);
        Set<Integer> levels = hd.keySet();
        for (Integer level : levels) {
            System.out.println("Level " + level + " : " + hd.get(level));
        }

    }
}
