package com.jayplabs.dsa.trees;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */

import com.jayplabs.dsa.common.Node;

import java.util.ArrayList;

/**
 Construct all possible BSTs for keys 1 to N
 In this article, first count of possible BST (Binary Search Trees)s is discussed, then construction of all possible BSTs.

 How many structurally unique BSTs for keys from 1..N?

 For example, for N = 2, there are 2 unique BSTs
 1               2
 \            /
 2         1

 For N = 3, there are 5 possible BSTs
 1            3        3        2      1
 \          /        /        /  \      \
 3        2         1        1    3      2
 /       /            \                    \
 2      1               2                    3

 We know that all node in left subtree are smaller than root and in right subtree are larger than root so
 if we have ith number as root, all numbers from 1 to i-1 will be in left subtree and i+1 to N will be in right subtree.
 If 1 to i-1 can form x different trees and i+1 to N can from y different trees then we will have x*y total trees
 when ith number is root and we also have N choices for root also so we can simply iterate from 1 to N for root and
 another loop for left and right subtree. If we take a closer look, we can notice that the count is basically n’th
 Catalan number. We have discussed different approaches to find n’th Catalan number here.


 How to construct all BST for keys 1..N?
 The idea is to maintain a list of roots of all BSTs. Recursively construct all possible left and right subtrees.
 Create a tree for every pair of left and right subtree and add the tree to list. Below is detailed algorithm.

 1) Initialize list of BSTs as empty.
 2) For every number i where i varies from 1 to N, do following
 ......a)  Create a new node with key as 'i', let this node be 'node'
 ......b)  Recursively construct list of all left subtrees.
 ......c)  Recursively construct list of all right subtrees.
 3) Iterate for all left subtrees
 a) For current leftsubtree, iterate for all right subtrees
 Add current left and right subtrees to 'node' and add
 'node' to list.

 Reference : http://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/

 */
public class ConstructAllBSTsForKeys1toN {

    public static ArrayList<Node> constructAllBSTs(int start, int end) {
        ArrayList<Node> list = new ArrayList<>(); // List to hold root of each constructed BST

        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i=start; i<=end;i++) {
            ArrayList<Node> leftSubtree = constructAllBSTs(start, i-1);
            ArrayList<Node> rightSubtree = constructAllBSTs(i+1, end);

            for (int j=0;j<leftSubtree.size();j++) {
                Node left = leftSubtree.get(j);
                for (int k=0;k<rightSubtree.size();k++) {
                    Node right = rightSubtree.get(k);
                    Node root = new Node(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }

    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }



    public static void main(String[] args) {
        ArrayList<Node> list = constructAllBSTs(1,3);

        for(int i=0;i<list.size();i++) {
            System.out.println("PreOrder");
            preOrder(list.get(i));
            System.out.println();
        }
    }
}
