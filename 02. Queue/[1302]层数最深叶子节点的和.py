# 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
# 输出：15
#  
# 
#  示例 2： 
# 
#  
# 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
# 输出：19
#  
# 
#  
# 
#  提示： 
# 
#  
#  树中节点数目在范围 [1, 10⁴] 之间。 
#  1 <= Node.val <= 100 
#  
# 
#  Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 152 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def deepestLeavesSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        cur_level = list()
        ans = None
        if root:
            cur_level.append(root)

        while cur_level:
            cur_level_val = list()
            next_level = list()
            for cur_node in cur_level:
                cur_level_val.append(cur_node.val)
                if cur_node.left:
                    next_level.append(cur_node.left)
                if cur_node.right:
                    next_level.append(cur_node.right)

            ans = cur_level_val
            cur_level = next_level
        return sum(ans)
        
# leetcode submit region end(Prohibit modification and deletion)
