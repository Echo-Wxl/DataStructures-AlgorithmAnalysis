# 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
# 
#  
# 
#  示例 1： 
#  
#  
# 输入：root = [1,null,2,3]
# 输出：[3,2,1]
#  
# 
#  示例 2： 
# 
#  
# 输入：root = []
# 输出：[]
#  
# 
#  示例 3： 
# 
#  
# 输入：root = [1]
# 输出：[1]
#  
# 
#  
# 
#  提示： 
# 
#  
#  树中节点的数目在范围 [0, 100] 内 
#  -100 <= Node.val <= 100 
#  
# 
#  
# 
#  进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
# 
#  Related Topics 栈 树 深度优先搜索 二叉树 👍 1008 👎 0


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    # def postOrder(self, root, ans):
    #     if root:
    #         self.postOrder(root.left, ans)
    #         self.postOrder(root.right, ans)
    #
    #         ans.append(root.val)

    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans = list()
        stack = list()

        pre = None

        while root or len(stack)>0:
            while root:
                stack.append(root)
                root = root.left

            root = stack[-1]

            if not root.right or root.right == pre:
                ans.append(root.val)
                stack.pop()
                pre = root
                root = None
            else:
                root = root.right

        return ans
# leetcode submit region end(Prohibit modification and deletion)
