package com.jayplabs.dsa.trees;

/**
 * Created by Chandra Gopalaiah on 9/24/16.
 */

import com.jayplabs.dsa.common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
In-place Convert BST into a Min-Heap
 Given a Binary Search Tree, convert it into a Min-Heap containing the same elements in O(n) time. Do this in-place.

 Input: Binary Search Tree
 8
 /    \
 4      12
 /  \     /  \
 2    6   10  14


 Output - Min Heap
 2
 /    \
 4        6
 /  \     /   \
 8    10  12   14
 [Or any other tree that follows Min Heap
 properties and has same keys]

 If we are allowed to use extra space, we can perform inorder traversal of the tree and store the keys in an
 auxiliary array. As we’re doing inorder traversal on a BST, array will be sorted. Finally, we construct a complete
 binary tree from the sorted array. We construct the binary tree level by level and from left to right by taking next
 minimum element from sorted array. The constructed binary tree will be a min-Heap. This solution works in O(n) time,
 but is not in-place.

 How to do it in-place?
 The idea is to convert the binary search tree into a sorted linked list first. We can do this by traversing the BST
 in inorder fashion. We add nodes at the beginning of current linked list and update head of the list using pointer
 to head pointer. Since we insert at the beginning, to maintain sorted order, we first traverse the right subtree
 before the left subtree. i.e. do a reverse inorder traversal.

 Finally we convert the sorted linked list into a min-Heap by setting the left and right pointers appropriately.
 We can do this by doing a Level order traversal of the partially built Min-Heap Tree using queue and traversing
 the linked list at the same time. At every step, we take the parent node from queue, make next two nodes of linked
 list as children of the parent node, and enqueue the next two nodes to queue. As the linked list is sorted,
 the min-heap property is maintained.

 Reference : http://www.geeksforgeeks.org/in-place-convert-bst-into-a-min-heap/
 */

public class BSTtoMinHeap {

    public Node convertToSLL(Node root, Node head) { // Reverse in-order traversal
        if (root != null) {
            //Visit right child
            head = convertToSLL(root.right, head);
            //Perform operation
            root.right = head;
            if (head != null)
                head.left = null;
            head = root;
            //Visit left child
            head = convertToSLL(root.left, head);
        }
        return head;
    }

    public Node createHeapFromSLL(Node head) {
        if (head == null) return null;

        Queue<Node> queue = new LinkedList<>();
        Node root = head;   //set head of list as heap root
        head = head.right;  //Move head of list to next
        root.right = null;  //Break the link
        queue.add(root);    //Enqueue the root

        while (head != null) {  // Iterate until the head of list is empty
            Node parent = queue.poll();

            Node leftChild = head;      // Get the left child from the list i.e head of the list
            head = head.right;          // Move head of list to next which will be right child
            leftChild.right = null;     // break the link
            parent.left = leftChild;    // attach left child to it's parent
            queue.add(leftChild);       // enqueue left child to build it's family
            if (head != null) {         // attach right child and prepare to build it's family
                Node rightChild = head;
                head = head.right;
                rightChild.right = null;
                parent.right = rightChild;
                queue.add(rightChild);
            }
        }
        return root;
    }

    public Node binaryTreeToMinHeap(Node root) {
        if (root == null) return null;

        //Step 1 : convert BST to sorted linked list
        Node head = convertToSLL(root, null);

        //Step 2 : create a heap from a sorted linked list
        Node minHeapRoot = createHeapFromSLL(head);

        return minHeapRoot;
    }

    public void printLevelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while(levelSize>0) {
                Node parent = queue.poll();
                System.out.print(parent.data + " ");
                if (parent.left!= null) queue.add(parent.left);
                if (parent.right!= null) queue.add(parent.right);
                levelSize--;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(15);
        root.right = new Node(35);
        root.left.left = new Node(10);
        root.left.right = new Node(18);
        root.right.left = new Node(32);
        root.right.right = new Node(40);
        BSTtoMinHeap bst = new BSTtoMinHeap();
        Node minHeapRoot = bst.binaryTreeToMinHeap(root);
        bst.printLevelOrder(minHeapRoot);
    }
}
