import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */
class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) return true;

        Stack sk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);

            if (c1 == '[' || c1 == '(' || c1 == '{') {
                sk.push(c1);
            } else {
                if (sk.size() == 0) {
                    return false;
                }

                Character top = (Character)sk.pop();
                switch(c1) {
                    case ']':
                    if (top != '[') {
                        return false;
                    }
                    break;
                    case ')':
                    if (top != '(') {
                        return false;
                    }
                    break;
                    case '}':
                    if (top != '{') {
                        return false;
                    }
                    break;
                    default:
                }
            }
        }

        if (sk.size() == 0) {
            return true;
        }

        return false;
    }
}

