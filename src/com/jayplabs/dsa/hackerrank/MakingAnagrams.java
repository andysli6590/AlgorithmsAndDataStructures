package com.jayplabs.dsa.hackerrank;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Chandra Gopalaiah on 11/7/16.
 */
public class MakingAnagrams {

    public static int numberNeeded(String first, String second) {
        int[] firstFreq = new int[26];
        int[] secondFreq = new int[26];

        for (char c : first.toCharArray()) {
            firstFreq[c - 'a']++;
        }

        for (char c : second.toCharArray()) {
            secondFreq[c - 'a']++;
        }

        int count = 0;

        for (int i=0;i<firstFreq.length;i++) {
            int freq = Math.abs(firstFreq[i] - secondFreq[i]);
            if (freq >= 1) {
                count =  count + freq;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberNeeded("imkhnpqnhlvaxlmrsskbyyrhwfvgteubrelgubvdmrdmesfxkpykprunzpustowmvhupkqsyjxmnptkcilmzcinbzjwvxshubeln",
                "wfnfdassvfugqjfuruwrdumdmvxpbjcxorettxmpcivurcolxmeagsdundjronoehtyaskpwumqmpgzmtdmbvsykxhblxspgnpgfzydukvizbhlwmaajuytrhxeepvmcltjmroibjsdkbqjnqjwmhsfopjvehhiuctgthrxqjaclqnyjwxxfpdueorkvaspdnywupvmy"));
    }
}
