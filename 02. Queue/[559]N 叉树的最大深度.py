# 给定一个 N 叉树，找到其最大深度。 
# 
#  最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
# 
#  N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入：root = [1,null,3,2,4,null,5,6]
# 输出：3
#  
# 
#  示例 2： 
# 
#  
# 
#  
# 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
# null,13,null,null,14]
# 输出：5
#  
# 
#  
# 
#  提示： 
# 
#  
#  树的深度不会超过 1000 。 
#  树的节点数目位于 [0, 10⁴] 之间。 
#  
# 
#  Related Topics 树 深度优先搜索 广度优先搜索 👍 324 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: Node
        :rtype: int
        """
        cur_level = list()
        ans = 0
        if root:
            cur_level.append(root)
        while cur_level:
            next_level = list()
            ans += 1
            for cur_node in cur_level:
                if cur_node.children:
                    next_level.extend(cur_node.children)
            cur_level = next_level
        return ans
# leetcode submit region end(Prohibit modification and deletion)
