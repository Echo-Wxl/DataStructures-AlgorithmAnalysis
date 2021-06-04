//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 889 👎 0


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
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        if (root != null) {
            Q.offer(root);
        }
        int ans = 0;
        while (Q.size() > 0) {
            int qSize = Q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = Q.poll();
                if (curNode.left != null) {
                    Q.offer(curNode.left);
                }
                if (curNode.right != null) {
                    Q.offer(curNode.right);
                }
            }
            ans+=1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
