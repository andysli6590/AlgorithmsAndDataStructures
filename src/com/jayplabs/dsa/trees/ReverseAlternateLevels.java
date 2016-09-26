package com.jayplabs.dsa.trees;

import com.jayplabs.dsa.common.Node;

import java.util.*;

/**
 * Created by Chandra Gopalaiah on 9/25/16.
 */
public class ReverseAlternateLevels {

    public static ArrayList<Integer> list = new ArrayList<>();

    public static void storeAlternateLevels(Node root, int level) {
        if (root != null) {
            storeAlternateLevels(root.left, level+1);
            if (level%2 != 0) {
                list.add(root.data);
            }
            storeAlternateLevels(root.right, level+1);
        }
    }

    public static void reverseAlternateLevels(Node root, int level) {
        if (root != null) {
            reverseAlternateLevels(root.left, level+1);
            if (level%2 != 0)
                root.data = list.remove(0);
            reverseAlternateLevels(root.right, level+1);
        }
    }

    public static void levelOrderQueue(Node root){
        Queue q = new LinkedList();
        int levelNodes =0;
        if(root==null) return;
        q.add(root);

        while(!q.isEmpty()){
            levelNodes = q.size();
            while(levelNodes>0){
                Node n = (Node)q.remove();
                System.out.print(" " + n.data);
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
                levelNodes--;
            }
            System.out.println("");
        }
    }

    public static void preOrderTechnique(Node root1, Node root2, int level) {
        if (root1 == null || root2 == null) return;

        if (level%2 == 0) {
            int temp = root1.data;
            root1.data = root2.data;
            root2.data = temp;
        }
        preOrderTechnique(root1.left, root2.right, level+1);
        preOrderTechnique(root1.right, root2.left, level+1);
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


        System.out.println("Original Tree : ");
        levelOrderQueue(root);
        //storeAlternateLevels(root, 0);
        //System.out.println("Before Reverse : " + list.toString());
        //Collections.reverse(list);
        //System.out.println("After Reverse : " + list.toString());
        //reverseAlternateLevels(root, 0);
        preOrderTechnique(root.left, root.right, 0);
        System.out.println("Reverse Tree : ");
        levelOrderQueue(root);
    }

}
