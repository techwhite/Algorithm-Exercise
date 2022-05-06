/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";

        if (strs.length == 1) return strs[0];

        StringBuilder sb = new StringBuilder();
        String firstStr = strs[0];
        for (int i = 0; i < firstStr.length(); i++) {
            Character c1 = firstStr.charAt(i);
            boolean isCommon = true;

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c1.charValue() != strs[j].charAt(i)) {
                    isCommon = false;
                    break;
                }
            }

            if (!isCommon) {
                break;
            } 

            sb.append(c1);
        }

        return sb.toString();
    }
}

