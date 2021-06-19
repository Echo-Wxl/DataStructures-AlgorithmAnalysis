//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 1081 👎 0


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
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        postOrder(root, p, q);
        return ans;
        
    }

    /**
     * 定义函数的返回值为统计结点的个数
     * 利用返回结点的个数，得到最低公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public int postOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int lcnt = postOrder(root.left, p, q);
        int rcnt = postOrder(root.right, p, q);

        if (lcnt == 1 && rcnt == 1) {
            ans = root;
        } else if (lcnt == 1 || rcnt == 1) {
            if (root == p || root == q) {
                ans = root;
            }
        }
        return lcnt + rcnt + ((root == p || root == q) ? 1 : 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
