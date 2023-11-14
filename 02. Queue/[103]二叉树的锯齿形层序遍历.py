# 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：root = [3,9,20,null,null,15,7]
# 输出：[[3],[20,9],[15,7]]
#  
# 
#  示例 2： 
# 
#  
# 输入：root = [1]
# 输出：[[1]]
#  
# 
#  示例 3： 
# 
#  
# 输入：root = []
# 输出：[]
#  
# 
#  
# 
#  提示： 
# 
#  
#  树中节点数目在范围 [0, 2000] 内 
#  -100 <= Node.val <= 100 
#  
# 
#  Related Topics 树 广度优先搜索 二叉树 👍 733 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        cur_level = list()
        ans = list()
        flag = False
        if root:
            cur_level.append(root)
        while cur_level:
            next_level = list()
            cur_level_val = list()
            for cur_node in cur_level:
                cur_level_val.append(cur_node.val)
                if cur_node.left:
                    next_level.append(cur_node.left)
                if cur_node.right:
                    next_level.append(cur_node.right)
            if flag:
                cur_level_val.reverse()
            ans.append(cur_level_val)
            cur_level = next_level
            flag = not flag
        return ans
        
# leetcode submit region end(Prohibit modification and deletion)
