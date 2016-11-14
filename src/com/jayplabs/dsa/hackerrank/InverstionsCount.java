package com.jayplabs.dsa.hackerrank;

/**
 * Created by Chandra Gopalaiah on 11/7/16.
 *
 *
 *
 *  https://www.hackerrank.com/challenges/ctci-merge-sort
 *
 *
 *
 * Tricky Part
 * Consider following case for split inversion : 1 3 5 6 | 2 4 7
 * These two are sorted sub-arrays. When you merge them 1 will need no inversions but 2 will have to invert
 * all of 3 5 6 to reach to its appropriate place. if you think deeply enough you will realize that it is in fact the case
 *
 */
public class InverstionsCount {

    private static long mergeSort(int[] a, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end)/2;
        long count = 0;
        count += mergeSort(a, start, mid);  //left inversions
        count += mergeSort(a, mid+1, end);  //right inversions
        count += merge(a, start, end);      // split inversions
        return count;
    }

    private static long merge(int[] a, int start, int end) {
        int mid = (start + end)/2;
        int count = 0;
        int i = start;
        int j = mid+1;
        int[] newArr = new int[end-start+1];
        int cur = 0;
        while (i<=mid && j<=end) {
            if (a[i] > a[j]) {
                newArr[cur++] = a[j++];
                count += mid - i + 1;   // Tricky part
            } else {
                newArr[cur++] = a[i++];
            }

        }
        // Leftover elements here
        while (i <= mid) {
            newArr[cur++] = a[i++];
        }

        while (j <= end) {
            newArr[cur++] = a[j++];
        }
        // Usual stuff from merge sort algorithm with arrays
        System.arraycopy(newArr, 0, a, start, end-start+1);
        return count;
    }

    public static long countInversions(int[] a){
        return mergeSort(a, 0, a.length-1);
    }

    public static void main(String[] args) {
        int[] a = new int[] {2,1,3,1,2};
        System.out.println(countInversions(a));
    }
}
