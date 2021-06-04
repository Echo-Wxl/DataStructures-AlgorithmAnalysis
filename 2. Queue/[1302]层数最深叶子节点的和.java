//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 104] 之间。 
// 1 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 
// 👍 54 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> curLevel = new LinkedList<>();
        if (root != null) {
            curLevel.add(root);
        }
        int ans = 0;
        while (curLevel.size() > 0) {
            List<TreeNode> nextLevel = new LinkedList<>();
            int sum = 0;
            for (TreeNode curNode : curLevel) {
                sum += curNode.val;
                if (curNode.left != null) {
                    nextLevel.add(curNode.left);
                }
                if (curNode.right != null) {
                    nextLevel.add(curNode.right);
                }
            }
            ans = sum;
            curLevel = nextLevel;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
