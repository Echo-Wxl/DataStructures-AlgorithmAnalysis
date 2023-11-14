# 给你一个链表数组，每个链表都已经按升序排列。 
# 
#  请你将所有链表合并到一个升序链表中，返回合并后的链表。 
# 
#  
# 
#  示例 1： 
# 
#  输入：lists = [[1,4,5],[1,3,4],[2,6]]
# 输出：[1,1,2,3,4,4,5,6]
# 解释：链表数组如下：
# [
#   1->4->5,
#   1->3->4,
#   2->6
# ]
# 将它们合并到一个有序链表中得到。
# 1->1->2->3->4->4->5->6
#  
# 
#  示例 2： 
# 
#  输入：lists = []
# 输出：[]
#  
# 
#  示例 3： 
# 
#  输入：lists = [[]]
# 输出：[]
#  
# 
#  
# 
#  提示： 
# 
#  
#  k == lists.length 
#  0 <= k <= 10^4 
#  0 <= lists[i].length <= 500 
#  -10^4 <= lists[i][j] <= 10^4 
#  lists[i] 按 升序 排列 
#  lists[i].length 的总和不超过 10^4 
#  
# 
#  Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2324 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __lr__(self, obj):
        return self.val < obj.val


import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        # ListNode按照val排序
        ListNode.__lt__ = lambda x, y: x.val < y.val

        heap = []
        for node in lists:
            if node:
                heapq.heappush(heap, (node.val, node))

        dummy = ListNode()
        tail = dummy

        while heap:
            cur_val, cur_node = heapq.heappop(heap)
            tail.next = cur_node
            tail = cur_node

            if cur_node.next:
                heapq.heappush(heap, (cur_node.next.val, cur_node.next))
        tail.next = None
        return dummy.next
# leetcode submit region end(Prohibit modification and deletion)
