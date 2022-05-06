/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int len = 0;
        while (x >= Math.pow(10, len)) len++;

        for (int i = 0; i < len; i++) {
            int lowDigit = x / (int)Math.pow(10, i) % 10;

            int highDigit = x / (int)Math.pow(10, len - 1 - i) % 10;

            if (lowDigit != highDigit) return false;
        }

        return true;
    }
}

