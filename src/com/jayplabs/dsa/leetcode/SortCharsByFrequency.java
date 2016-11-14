package com.jayplabs.dsa.leetcode;

import java.util.HashMap;

/**
 * Created by Chandra Gopalaiah on 11/6/16.
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/
 *
 */

public class SortCharsByFrequency {

    public static String frequencySort(String s) {

        int max = 0;
        int[] map = new int[256];
        for (char ch : s.toCharArray()) {
            map[ch]++;
            max = Math.max(max, map[ch]);
        }

        String[] buckets = new String[max+1];
        for (int i = 0; i < 256; i++) {
            String str = buckets[map[i]];
            if (map[i] > 0) {
                buckets[map[i]] = (str == null) ? "" + (char)i : (str + (char) i);
            }
        }

        StringBuilder strb = new StringBuilder();
        for(int i = max; i >= 0; i--) { // create string for each bucket.
            if(buckets[i] != null)
                for(char ch : buckets[i].toCharArray())
                    for(int j = 0; j < i; j++)
                        strb.append(ch);
        }
        return strb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }


}
