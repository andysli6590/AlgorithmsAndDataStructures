package com.jayplabs.dsa.hackerrank;

import java.util.Stack;

/**
 * Created by Chandra Gopalaiah on 11/7/16.
 *
 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left.
 * For example, if left rotations are performed on array , then the array would become.
 *
 * Given an array of  integers and a number, , perform  left rotations on the array.
 * Then print the updated array as a single line of space-separated integers.
 *
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 */
public class ArrayLeftRotation {

    private static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        if (k > n || n <= 1) return a;

        reverse(a, 0, k-1); // reverse the numbers of elements undergo rotation
        reverse(a, k, n-1); // reverse the rest of the elements
        reverse(a, 0, n-1); // reverse all elements

        return a;
    }

    public static int[] arrayLeftRotationUsingStack(int[] a, int n, int k) {
        if (k > n || n <= 1) return a;

        Stack<Integer> stack = new Stack<>();
        for (int i=k-1;i>=0;i--)
            stack.push(a[i]);

        for (int i=n-1;i>=k;i--)
            stack.push(a[i]);

        int[] output = new int[n];
        int i=0;
        while (!stack.isEmpty() && i < n) {
            output[i++] = stack.pop();
        }

        return output;

    }

    public static int[] arrayLeftRotationUsingArrayCopy(int[] a, int n, int k) {
        int[] output = new int[n];

        System.arraycopy(a, k, output, 0, n-k);
        System.arraycopy(a, 0, output, n-k, k);
        return output;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] a = new int[]{1,2,3,4,5};
        int k = 2;

        int[] output = arrayLeftRotationUsingArrayCopy(a, n, k);
        for (int ele : output) {
            System.out.print(ele + " ");
        }
    }
}
