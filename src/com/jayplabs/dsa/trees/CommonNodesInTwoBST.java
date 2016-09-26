package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

import java.util.Stack;

/**
 * Created by Chandra Gopalaiah on 9/24/16.
 */

/**
Print Common Nodes in Two Binary Search Trees
        Given two Binary Search Trees, find common nodes in them. In other words, find intersection of two BSTs.

Example:
         5                           10
       /   \                       /    \
      1    10                     7     20
     / \   /                     / \
    0  4  7                     4   9
           \
            9

Output: 4 7 9 10

 Method 1 (Simple Solution) A simple way is to one by once search every node of first tree in second tree.
 Time complexity of this solution is O(m * h) where m is number of nodes in first tree and h is height of second tree.

 Method 2 (Linear Time) We can find common elements in O(n) time.
 1) Do inorder traversal of first tree and store the traversal in an auxiliary array ar1[]. See sortedInorder() here.
 2) Do inorder traversal of second tree and store the traversal in an auxiliary array ar2[]
 3) Find intersection of ar1[] and ar2[]. See this for details.

 Time complexity of this method is O(m+n) where m and n are number of nodes in first and second tree respectively.
 This solution requires O(m+n) extra space.

 Method 3 (Linear Time and limited Extra Space) We can find common elements in O(n) time and O(h1 + h2) extra space
 where h1 and h2 are heights of first and second BSTs respectively.
 The idea is to use iterative inorder traversal. We use two auxiliary stacks for two BSTs. Since we need to find
 common elements, whenever we get same element, we print it.

 Reference : http://www.geeksforgeeks.org/print-common-nodes-in-two-binary-search-trees/
*/

public class CommonNodesInTwoBST {

    public void printCommon(Node root1, Node root2) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        while(true) {
            if (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            } else if (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            } else if (!stack1.isEmpty() && !stack2.isEmpty()) {
                root1 = stack1.peek();
                root2 = stack2.peek();

                if (root1.data == root2.data) {
                    System.out.println(root1.data);
                    stack1.pop();
                    stack2.pop();

                    root1 = root1.right;
                    root2 = root2.right;
                } else if (root1.data < root2.data) {
                    stack1.pop();
                    root1 = root1.right;
                    root2 = null;
                } else if (root1.data > root2.data) {
                    stack2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(5);
        root1.left = new Node(1);
        root1.right = new Node(10);
        root1.left.left = new Node(0);
        root1.left.right = new Node(4);
        root1.right.left = new Node(7);
        root1.right.left.right = new Node(9);

        Node root2 = new Node(10);
        root2.left = new Node(7);
        root2.right = new Node(20);
        root2.left.left = new Node(4);
        root2.left.right = new Node(9);

        CommonNodesInTwoBST tree = new CommonNodesInTwoBST();
        tree.printCommon(root1, root2);
    }
}
