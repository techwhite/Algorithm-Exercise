/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现strStr()
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        Map<Character, Queue<Integer>> charIndexMap = new HashMap<>();

        for (int i = 0; i < needle.length(); i++) {
            charIndexMap.put(needle.charAt(i),  new LinkedList<>());
        }

        for (int i = 0; i < haystack.length(); i++) {
            Character c = haystack.charAt(i);
            if (charIndexMap.containsKey(c)) {
                charIndexMap.get(c).add(i);
            }
        }

        int pre = -1;
        int pos = -1;
        for (int i = 0; i < needle.length(); i++) {
            Character c = needle.charAt(i);
            if (!charIndexMap.containsKey(c)) {
                return -1;
            }

            Queue<Integer> queue = charIndexMap.get(c);
            if (queue.size() == 0) {
                return -1;
            }
            
            int index = queue.poll();

            if (pre > 0 && pre + 1 != index) {
                return -1;
            } 

            if (pos == -1) {
                pos = index;
            }

            pre = index;
        }

        return pos;
    } 
}

