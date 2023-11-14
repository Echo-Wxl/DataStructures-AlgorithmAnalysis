"""
【题目】给定一个链表，需要把链表从中间拆分成长度相等的两半（如果链表长度为奇数，那么拆分之后，前半部分长度更长一点）。

输入：[1->2->3->4->5]

输出：[1->2->3, 4->5]

【分析】我们需要分为 2 步：

找到链表的中间结点

从中间结点把链表分为两半
"""
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def splitList(self, head):
        mid = self.splitList(head)
        back = mid.next
        mid.next = None

        return head, back

    def find_middle(self, head):
        front = head
        back = head
        pre = back
        while front is not None and front.next:
            pre = back
            front = front.next.next
            back = back.next
        return back if front else pre
