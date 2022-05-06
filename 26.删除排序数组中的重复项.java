/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int newPos = 0;
        int i = 0;
        while(i < nums.length - 1) {
            if (nums[i] != nums[i+1]) {
                nums[newPos++] = nums[i];                
            } 

            i++;
        } 

        nums[newPos] = nums[i];

        return newPos + 1;
    }
}

