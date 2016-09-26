package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class InAndPostOrderToBT {

    public static Node constructBT(int[] inorder, int[] postorder, int iStart, int iEnd, int pStart, int pEnd) {
        if (iStart>iEnd || pStart>pEnd) return null;

        int rootValue = postorder[pEnd];
        Node root = new Node(rootValue);

        if (iStart == iEnd) return root;

        int index = getInorderIndex(inorder, iStart, iEnd, rootValue);
        root.left = constructBT(inorder, postorder, iStart, index-1, pStart, pStart + index - (iStart+1));
        root.right = constructBT(inorder, postorder, index+1, iEnd, pStart+index-iStart, pEnd-1);
        return root;
    }

    public static int getInorderIndex(int[] inorder, int iStart, int iEnd, int value) {
        int index = -1;
        for (int i=iStart;i<=iEnd;i++) {
            if (inorder[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void printLEVELORDER(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                Node node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                levelSize--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
        int[] postOrder = {4, 5, 2, 6, 7, 3, 1};
        Node root = constructBT(inOrder, postOrder, 0, inOrder.length-1, 0, postOrder.length-1);
        printLEVELORDER(root);

    }
}
