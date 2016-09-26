package com.jayplabs.dsa.trees;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */

import com.jayplabs.dsa.common.Node;

import java.util.*;

/**
facebook-interview

        Given the root of a binary tree containing integers, print the columns of the tree in order with the nodes in each column printed top-to-bottom.


        Input:
         6
        / \
       3   4
      / \   \
     5   1   0
    / \     /
   9   2   8
        \
        7

        Output:
        9 5 3 2 6 1 7 4 8 0

        Input:
           1
         /  \
        2    3
       / \  / \
      4  5 6   7

        When two nodes share the same position (e.g. 5 and 6), they may be printed in either order:

        Output:
        4 2 1 5 6 3 7
        or:
        4 2 1 6 5 3 7

 Approach:
 1. Lets record the horizontal (left, right) distance of each node from root
 2. To record horizontal distance for a node from root , lets see as how many lefts and how many rights do we need to
 travel from root's horizontal position to reach the node's horizontal position.
 3. Lets take 1 Left step as -1 and 1 Right step as +1.



 */
public class ColumnWiseTreeTraversal {

    public static void printColumnWiseNodes(Node root) {
        // Initialize a map which stores distance from root and  list all nodes at that distance from root
        Map<Integer, List<Node>> map = new TreeMap<>(); // Treemap preserves the order
        initialize(root, 0, map);
        Set<Integer> distances = map.keySet(); // Since distances should be unique from root, hence set
        for (Integer distance : distances) {
            List<Node> nodes = map.get(distance); // Retrieve list associated with each distance
            for (Node node : nodes) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    //Initialize map in preorder traversal
    // Problem with this is when prints nodes in same column, the order of nodes are not in sequential
    public static void initialize(Node root, int distanceFromRoot, Map<Integer, List<Node>> map) {
        if (root != null) {
            List<Node> list = map.get(distanceFromRoot); //Retrieve the list of nodes if present for the distance
            if (list == null) {
                list = new ArrayList<>();
                map.put(distanceFromRoot, list);
            }
            list.add(root);
            initialize(root.left, distanceFromRoot-1, map);
            initialize(root.right, distanceFromRoot+1, map);
        }
    }

    // We need to perform level order traversal such that order of nodes in same column are preserved
   public static void printVerticalOrder(Node root) {
       if (root == null) return;

       TreeMap<Integer, ArrayList<Node>> map = new TreeMap<>(); //stores (column index, nodes in that column)
       Queue<Node> queue = new LinkedList<>(); //queue to perform level order traversal
       queue.add(root);

       HashMap<Node, Integer> indexMap = new HashMap<>(); //stores (node, its column index)
       indexMap.put(root, 0);

       //level order traversal
       while(!queue.isEmpty()) {
           int levelOrder = queue.size();
           while (levelOrder > 0) {
               Node node = queue.poll();
               int colIndex = indexMap.get(node); //find column index for current node

               //add current node to corresponding column list
               ArrayList<Node> list = map.get(colIndex);
               if (list == null) {
                   list = new ArrayList<>();
                   map.put(colIndex, list);
               }
               list.add(node);

               //add children
               if (node.left != null) {
                   indexMap.put(node.left, colIndex-1); //column index for left child is rootIndex - 1
                   queue.add(node.left);
               }

               if (node.right != null) {
                   indexMap.put(node.right, colIndex+1); //column index for right child is rootIdx + 1
                   queue.add(node.right);
               }
               levelOrder--;
           }
       }

       Set<Integer> distances = map.keySet();
       for(Integer distance : distances) {
           ArrayList<Node> nodes = map.get(distance);
           for (Node node : nodes) {
               System.out.print(node.data + " ");
           }
           System.out.println();
       }
   }

    public static void printVerticalOrder1(Node root) {

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
                    map.put(level, list);
                }
                list.add(node);

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

        printColumnWiseNodes(root);
        printVerticalOrder(root);
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
