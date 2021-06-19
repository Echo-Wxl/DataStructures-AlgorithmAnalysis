//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 263 👎 0


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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        if (root != null) {
            Q.offer(root);
        }
        List<Double> ans = new ArrayList<>();
        while (Q.size() > 0) {
            int qSize = Q.size();
            double sum = 0;
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = Q.poll();
                sum += curNode.val;
                if (curNode.left != null) {
                    Q.offer(curNode.left);
                }
                if (curNode.right != null) {
                    Q.offer(curNode.right);
                }
            }
            ans.add(sum /qSize);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
