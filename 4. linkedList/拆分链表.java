/*
给定一个链表，需要把链表从中间拆分成长度相等的两半（如果链表长度为奇数，那么拆分之后，前半部分长度更长一点）。

输入：[1->2->3->4->5]

输出：[1->2->3, 4->5]

【分析】我们需要分为 2 步：

1. 找到链表的中间结点

2. 从中间结点把链表分为两半
 */
class Solution{
    public ListNode findMiddleNode(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode s1 = head;
        ListNode s2 = head;
        ListNode pre = dummy;
        while (s2 != null && s2.next != null) {
            s2 = s2.next.next;
            pre = s1;
            s1 = s1.next;
        }
        return s2 == null ? pre:s1;
    }

    public ListNode[] split(ListNode head) {
        ListNode mid = findMiddleNode(head);
        ListNode back = mid.next;
        mid.next = null;
        return new ListNode[]{head, back};
    }
}