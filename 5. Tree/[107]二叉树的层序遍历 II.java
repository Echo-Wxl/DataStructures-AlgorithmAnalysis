//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 428 👎 0


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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        if (root != null) {
            cur.add(root);
        }
        while (cur.size() > 0) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> result = new ArrayList<>();
            for (TreeNode curNode : cur) {
                result.add(curNode.val);
                if (curNode.left != null) {
                    next.add(curNode.left);
                }
                if (curNode.right != null) {
                    next.add(curNode.right);
                }
            }
            cur = next;
            ans.add(result);
        }
        Collections.reverse(ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
