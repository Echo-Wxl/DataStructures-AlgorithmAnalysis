//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 259 👎 0


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

/**
 * 思路：需要先得到子树的信息，所以是后序遍历
 * 1. 将二叉树序列化成字符串子树
 * 2. 在hashmap中记录子树和出现的次数
 *
 */
class Solution {
    List<TreeNode> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subTree(root);
        return ans;
    }

    private String subTree(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = subTree(root.left);
        String right = subTree(root.right);

        String subtree = left+","+right+","+root.val;

        int freq = map.getOrDefault(subtree, 0);

        if (freq == 1) {
            ans.add(root);
        }

        map.put(subtree, freq+1);
        return subtree;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
