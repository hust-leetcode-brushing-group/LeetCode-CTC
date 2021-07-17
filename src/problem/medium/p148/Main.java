package problem.medium.p148;

import common.ListNode;

/**
 * 148. 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 */
public class Main {
    public static void main(String[] args) {
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * @author caoPhoenix
 * @date 2020/9/1
 * 执行用时：3 ms, 在所有 Java 提交中击败了99.06% 的用户
 * 内存消耗：42.4 MB, 在所有 Java 提交中击败了27.37% 的用户
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode l) {
        if (l == null || l.next == null) return l;
        ListNode fast = l, slow = l;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode l1 = l;
        l1 = mergeSort(l1);
        l2 = mergeSort(l2);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode p = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        while (l1 != null) {
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }
        while (l2 != null) {
            p.next = l2;
            l2 = l2.next;
            p = p.next;

        }
        return head;
    }
}