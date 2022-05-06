/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */
class Solution {
    public int reverse(int x) {
        if (x == 0) return x;
        long mabx = Math.abs((long)x);
        if (mabx < 10) return x;

        int sig = (int)(x / mabx);

        String input = String.valueOf(mabx);

        int j = input.length() - 1;
        StringBuilder sb = new StringBuilder(input.length());
        boolean metNoZero = false;
        while (j >= 0) {
            if (metNoZero || input.charAt(j) != '0') {
                sb.append(input.charAt(j));
                metNoZero = true;
            } 

            j--;
        }

        long resLong = Long.valueOf(sb.toString());
        if (resLong > Integer.MAX_VALUE) resLong = 0;

        return (int)resLong * sig;
    }
}

