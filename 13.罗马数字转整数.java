import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> charValue = new HashMap<>();
        charValue.put('I', 1);
        charValue.put('V', 5);
        charValue.put('X', 10);
        charValue.put('L', 50);
        charValue.put('C', 100);
        charValue.put('D', 500);
        charValue.put('M', 1000);

        Map<String, Integer> specialMap = new HashMap<>();
        specialMap.put("IV", 4);
        specialMap.put("IX", 9);
        specialMap.put("XL", 40);
        specialMap.put("XC", 90);
        specialMap.put("CD", 400);
        specialMap.put("CM", 900);

        Set<Character> specialSet = new HashSet<>();
        specialSet.add('I');
        specialSet.add('X');
        specialSet.add('C');

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            Character curChar = s.charAt(i);

            if (!charValue.containsKey(curChar)) {
                continue;
            }

            if (specialSet.contains(curChar) && i < s.length() -1) {
                String specialStr = s.substring(i, i+2);
                if (specialMap.containsKey(specialStr)) {
                    sum += specialMap.get(specialStr);
                    i++;

                    continue;
                } 
            }

            sum += charValue.get(curChar);
        }

        return sum;
    }
}

