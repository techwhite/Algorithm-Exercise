/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(0);
        head.next = l1;
        ListNode pre = head;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {            
                pre = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
                pre.next = l1;
            }
        }

        if (l2 != null) {
            pre.next = l2;
        }

        return head.next;
    }
}

