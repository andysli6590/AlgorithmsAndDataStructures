package com.jayplabs.dsa.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Chandra Gopalaiah on 11/6/16.
 *
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target-nums[i]);
                result[1] = i;
            } else if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,4};
        int target = 6;

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
