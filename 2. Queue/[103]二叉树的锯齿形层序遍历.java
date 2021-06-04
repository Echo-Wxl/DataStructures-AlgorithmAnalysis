//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 450 👎 0


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<>();
        if (root != null) {
            Q.offer(root);
        }
        boolean reverse = false;
        List<List<Integer>> ans = new LinkedList<>();
        while (Q.size() > 0) {
            int qSize = Q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode curNode = Q.poll();
                temp.add(curNode.val);
                if (curNode.left != null) {
                    Q.offer(curNode.left);
                }
                if (curNode.right != null) {
                    Q.offer(curNode.right);
                }
            }
            if (reverse) {
                Collections.reverse(temp);
            }
            reverse = !reverse;
            ans.add(temp);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
