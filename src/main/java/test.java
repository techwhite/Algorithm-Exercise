import java.util.HashMap;
import java.util.Map;

class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        
        System.out.println(create(new int[]{1,2,4}));
    }

    static ListNode create(int[] aray) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for (int i = 0; i < aray.length; i++) {
            ListNode node = new ListNode(aray[i]);
            node.next = null;

            pre.next = node;
            pre = node;
        }

        return head.next;
    }
}

