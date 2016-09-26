package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

import java.util.*;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class PrintTopView {
    public static void topView(Node root) {

        TreeMap<Integer, ArrayList<Node>> map = new TreeMap<>();
        Queue<QueuePack> queue = new LinkedList<>();

        queue.add(new QueuePack(0, root));

        while (!queue.isEmpty()) {
            int levelOrder = queue.size();
            while (levelOrder > 0) {
                QueuePack q = queue.poll();
                Node node = q.tNode;
                int level = q.level;

                ArrayList<Node> list = map.get(level);
                if (list == null) {
                    list = new ArrayList<>();
                    list.add(node); // If this line is moved out of if condition then we can print tree column wise
                    map.put(level, list);
                }


                if (node.left != null) {
                    queue.add(new QueuePack(level - 1, node.left));
                }

                if (node.right != null)
                    queue.add(new QueuePack(level + 1, node.right));

                levelOrder--;
            }
        }

        Set<Integer> distances = map.keySet();
        for (Integer distance : distances) {
            ArrayList<Node> nodes = map.get(distance);
            for (Node node : nodes) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
            Node root = new Node(6);
            root.left = new Node(3);
            root.right = new Node(4);
            root.left.left = new Node(5);
            root.left.right = new Node(1);
            root.left.left.left = new Node(9);
            root.left.left.right = new Node(2);
            root.left.left.right.right = new Node(7);
            root.right.right = new Node(0);
            root.right.right.left = new Node(8);

            topView(root);
    }

    static class QueuePack {
        Node tNode;
        int level;

        public QueuePack(int level, Node tNode) {
            this.level = level;
            this.tNode = tNode;
        }
    }
}
