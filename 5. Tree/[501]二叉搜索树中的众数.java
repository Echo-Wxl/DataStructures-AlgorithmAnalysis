//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 315 👎 0


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

/*
class Solution {
    int maxCount = 0;
    int preValue = Integer.MIN_VALUE;
    int ansCount = 0;

    private void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        inOrder(root.left, ans);
        if (preValue == root.val) {
            maxCount++;
        } else {
            preValue = root.val;
            maxCount = 1;
        }

        if (ans != null) {
            if (maxCount == ansCount) {
                ans.add(preValue);
            }
        }
        ansCount = Math.max(maxCount, ansCount);
        inOrder(root.right, ans);

    }
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        inOrder(root, null);

        maxCount = 0;
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans.stream().mapToInt(i->i).toArray();
    }
}
 */

class Solution{
    private int maxCount = 0;
    private int ansCount = 0;
    private int preValue = Integer.MIN_VALUE;
    private List<Integer> ans = new ArrayList<>();

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (preValue == root.val) {
            maxCount++;
        } else {
            preValue = root.val;
            maxCount = 1;
        }

        if (maxCount == ansCount) {
            ans.add(root.val);
        } else if (maxCount > ansCount) {
            ansCount = maxCount;
            ans.clear();
            ans.add(root.val);
        }

        inOrder(root.right);

    }
    public int[] findMode(TreeNode root) {
        inOrder(root);
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
