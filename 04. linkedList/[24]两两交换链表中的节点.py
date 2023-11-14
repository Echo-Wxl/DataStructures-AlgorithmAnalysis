# 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：head = [1,2,3,4]
# 输出：[2,1,4,3]
#  
# 
#  示例 2： 
# 
#  
# 输入：head = []
# 输出：[]
#  
# 
#  示例 3： 
# 
#  
# 输入：head = [1]
# 输出：[1]
#  
# 
#  
# 
#  提示： 
# 
#  
#  链表中节点的数目在范围 [0, 100] 内 
#  0 <= Node.val <= 100 
#  
# 
#  Related Topics 递归 链表 👍 1717 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        odd = ListNode()
        odd_tail = odd

        even = ListNode()
        even_tail = even
        flag = True
        while head:
            if flag:
                odd_tail.next = head
                odd_tail = odd_tail.next
            else:
                even_tail.next = head
                even_tail = even_tail.next

            head = head.next
            flag = not flag
        odd_tail.next = None
        even_tail.next = None

        return self.mergeTwoLists(
            odd.next, even.next
        )

    def mergeTwoLists(self, list1, list2):
        flag = True
        dummy = ListNode()
        tail = dummy

        while list1 or list2:
            if not list1 or (flag and list2):
                tail.next = list2
                tail = tail.next
                list2 = list2.next
            else:
                tail.next = list1
                tail = tail.next
                list1 = list1.next

            flag = not flag
        tail.next = None
        return dummy.next
# leetcode submit region end(Prohibit modification and deletion)
