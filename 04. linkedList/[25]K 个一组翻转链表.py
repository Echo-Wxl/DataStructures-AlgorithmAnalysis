# 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
# 
#  k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
# 
#  你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：head = [1,2,3,4,5], k = 2
# 输出：[2,1,4,3,5]
#  
# 
#  示例 2： 
# 
#  
# 
#  
# 输入：head = [1,2,3,4,5], k = 3
# 输出：[3,2,1,4,5]
#  
# 
#  
# 提示：
# 
#  
#  链表中的节点数目为 n 
#  1 <= k <= n <= 5000 
#  0 <= Node.val <= 1000 
#  
# 
#  
# 
#  进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
# 
#  
#  
# 
#  Related Topics 递归 链表 👍 1917 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """

        dummy = ListNode()
        ans_tail = dummy

        temp_dummy = ListNode()
        temp_tail = temp_dummy

        idx = 0

        p = head

        while p:
            back = p.next
            p.next = None

            temp_tail.next = p
            temp_tail = p
            idx += 1

            if idx == k:
                tail = temp_dummy.next
                reversed_head = self.reverseList(temp_dummy.next)

                ans_tail.next = reversed_head
                ans_tail = tail

                idx = 0

                temp_dummy.next = None
                temp_tail = temp_dummy

            p = back

        if idx > 0:
            ans_tail.next = temp_dummy.next
            ans_tail = temp_tail

        ans_tail.next = None

        return dummy.next

    def reverseList(self, head):
        dummy = ListNode()

        p = head

        while p:
            back = p.next

            p.next = dummy.next
            dummy.next = p

            p = back

        return dummy.next
# leetcode submit region end(Prohibit modification and deletion)
