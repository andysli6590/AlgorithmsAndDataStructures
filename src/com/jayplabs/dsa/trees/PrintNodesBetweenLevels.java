package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class PrintNodesBetweenLevels {

    static public int currentLevel = 1;
    public static void printNodesBetweenLevels(Node root, int low, int high) {
        Queue<Node> queue = new LinkedList<>();


        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                Node node = queue.poll();
                if (currentLevel >= low && currentLevel <= high) {
                    System.out.print(node.data + " ");
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                levelSize--;
            }
            if (currentLevel >= low && currentLevel <= high) {
                System.out.print(" ");
            }
            currentLevel++;
        }
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

        printNodesBetweenLevels(root, 2, 3);
    }
 }
