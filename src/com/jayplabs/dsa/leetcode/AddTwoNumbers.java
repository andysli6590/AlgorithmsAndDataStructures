package com.jayplabs.dsa.leetcode;

/**
 * Created by Chandra Gopalaiah on 11/6/16.
 *
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;
        int v1, v2;
        while (l1 != null || l2 != null) {
            if (l1 == null) v1 = 0;
            else {
                v1 = l1.val;
                l1 = l1.next;
            }

            if (l2 == null) v2 = 0;
            else {
                v2 = l2.val;
                l2 = l2.next;
            }

            int s = v1 + v2 + carry;
            carry = s/10;

            current.next = new ListNode(s%10);
            current = current.next;
        }

        if (carry == 1)
            current.next = new ListNode(carry);

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }