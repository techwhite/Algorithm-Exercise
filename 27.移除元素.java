/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return nums.length;

        int newPos = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[newPos++] = nums[i];
            }
            i++;
        }

        return newPos;
    }
}

