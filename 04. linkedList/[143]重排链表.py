# 给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
# 
#  
# L0 → L1 → … → Ln - 1 → Ln
#  
# 
#  请将其重新排列后变为： 
# 
#  
# L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
# 
#  不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入：head = [1,2,3,4]
# 输出：[1,4,2,3] 
# 
#  示例 2： 
# 
#  
# 
#  
# 输入：head = [1,2,3,4,5]
# 输出：[1,5,2,4,3] 
# 
#  
# 
#  提示： 
# 
#  
#  链表的长度范围为 [1, 5 * 10⁴] 
#  1 <= node.val <= 1000 
#  
# 
#  Related Topics 栈 递归 链表 双指针 👍 1142 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: None Do not return anything, modify head in-place instead.
        """
        mid = self.find_middle(head)
        front = head
        back = mid.next
        mid.next = None

        back_reverse = self.reverse(back)

        flag = True
        dummy = ListNode()
        tail = dummy
        while front or back_reverse:
            if not back_reverse or flag and front:
                tail.next = front
                tail = tail.next
                front = front.next
            else:
                tail.next = back_reverse
                tail = tail.next
                back_reverse = back_reverse.next

            flag = not flag

        return dummy.next


    def reverse(self, head):
        dummy = ListNode()
        p = head
        while p:
            back = p.next
            p.next = dummy.next
            dummy.next = p
            p = back
        return dummy.next

    def find_middle(self, head):
        front = head
        back = head
        pre = back

        while front and front.next:
            pre = back
            front = front.next.next
            back = back.next

        return back if front else pre
# leetcode submit region end(Prohibit modification and deletion)
