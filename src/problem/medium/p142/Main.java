package problem.medium.p142;

import common.ListNode;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class Main {
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * @author caoPhoenix
 * @date 2020/9/10
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了52.56% 的用户
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) break;
        }
        // 无环
        if (f.next == null || f.next.next == null) return null;
        // 快慢指针相遇后，快指针变成从头开始走的满指针，再次相遇即入环的节点
        f = head;
        while (f.next != null && s.next != null) {
            f = f.next;
            s = s.next;
            if ((f == s)) return f;
        }
        return null;
    }
}