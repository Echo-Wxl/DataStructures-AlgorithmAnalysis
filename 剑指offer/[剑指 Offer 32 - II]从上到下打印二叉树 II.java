//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 116 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> curNode = new ArrayList<>();
        if (root != null) {
            curNode.add(root);
        }
        while (curNode.size() > 0) {
            List<TreeNode> nextNode  = new ArrayList<>();
            List<Integer> curVal = new ArrayList<>();
            for (TreeNode node : curNode) {
                curVal.add(node.val);
                if (node.left != null) {
                    nextNode.add(node.left);
                }
                if (node.right != null) {
                    nextNode.add(node.right);
                }
            }
            ans.add(curVal);
            curNode = nextNode;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
