package leetcode;

import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!hash.containsKey(nums[i])) {
                hash.put(target - nums[i], i);
            } else {
                int beginIndice = hash.get(nums[i]);
                int rightIndice = i;

                return new int[] {beginIndice, rightIndice};
            }
        }

        return null;
    }
}

