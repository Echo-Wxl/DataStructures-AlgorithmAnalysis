# 给定一个非空二叉树的根节点
#  root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10⁻⁵ 以内的答案可以被接受。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入：root = [3,9,20,null,null,15,7]
# 输出：[3.00000,14.50000,11.00000]
# 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
# 因此返回 [3, 14.5, 11] 。
#  
# 
#  示例 2: 
# 
#  
# 
#  
# 输入：root = [3,9,20,15,7]
# 输出：[3.00000,14.50000,11.00000]
#  
# 
#  
# 
#  提示： 
# 
#  
#  
# 
#  
#  树中节点数量在 [1, 10⁴] 范围内 
#  -2³¹ <= Node.val <= 2³¹ - 1 
#  
# 
#  Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 390 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
import Queue as queue
class Solution(object):
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        q = queue.Queue()
        ans = list()
        if root:
            q.put(root)

        while not q.empty():
            q_size = q.qsize()
            sum_level = 0.0
            for i in range(q_size):
                cur_node = q.get()
                sum_level += cur_node.val
                if cur_node.left:
                    q.put(cur_node.left)
                if cur_node.right:
                    q.put(cur_node.right)

            ans.append(sum_level/q_size)

        return ans
        
# leetcode submit region end(Prohibit modification and deletion)
