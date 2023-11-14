# 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
# 
#  树的 最大宽度 是所有层中最大的 宽度 。 
# 
#  
#  
#  每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
# null 节点，这些 null 节点也计入长度。 
#  
#  
# 
#  题目数据保证答案将会在 32 位 带符号整数范围内。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：root = [1,3,2,5,3,null,9]
# 输出：4
# 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
#  
# 
#  示例 2： 
#  
#  
# 输入：root = [1,3,2,5,null,null,9,6,null,7]
# 输出：7
# 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
#  
# 
#  示例 3： 
#  
#  
# 输入：root = [1,3,2,5]
# 输出：2
# 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
#  
# 
#  
# 
#  提示： 
# 
#  
#  树中节点的数目范围是 [1, 3000] 
#  -100 <= Node.val <= 100 
#  
# 
#  Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 537 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def widthOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        cur_level = list()
        ans = 0
        if root:
            cur_level.append((root, 0))

        while cur_level:
            next_level = list()
            start = -1
            end = 0
            for i in range(len(cur_level)):
                cur_node = cur_level[i]
                if start == -1:
                    start = cur_node[1]
                end = cur_node[1]
                if cur_node[0].left:
                    next_level.append((cur_node[0].left, 2 * cur_node[1]))
                if cur_node[0].right:
                    next_level.append((cur_node[0].right, 2 * cur_node[1] + 1))
            cur_level = next_level
            ans = max(ans, end - start + 1)
        return ans
# leetcode submit region end(Prohibit modification and deletion)
