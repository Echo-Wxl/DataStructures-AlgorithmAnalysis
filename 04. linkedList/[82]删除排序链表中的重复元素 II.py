# 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：head = [1,2,3,3,4,4,5]
# 输出：[1,2,5]
#  
# 
#  示例 2： 
#  
#  
# 输入：head = [1,1,1,2,3]
# 输出：[2,3]
#  
# 
#  
# 
#  提示： 
# 
#  
#  链表中节点数目在范围 [0, 300] 内 
#  -100 <= Node.val <= 100 
#  题目数据保证链表已经按升序 排列 
#  
# 
#  Related Topics 链表 双指针 👍 1059 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        tmp_dummy = ListNode()
        tmp_tail = tmp_dummy

        dummy = ListNode()
        tail = dummy

        while head:
            if tmp_dummy == tmp_tail or head.val ==tmp_tail.val:
                tmp_tail.next = head
                tmp_tail = tmp_tail.next
            else:
                if tmp_tail == tmp_dummy.next:
                    tail.next = tmp_tail
                    tail = tail.next
                tmp_dummy.next = head
                tmp_tail = head
            head = head.next

        if tmp_tail == tmp_dummy.next:
            tail.next = tmp_tail
            tail = tail.next

        tail.next = None
        return dummy.next



# leetcode submit region end(Prohibit modification and deletion)
