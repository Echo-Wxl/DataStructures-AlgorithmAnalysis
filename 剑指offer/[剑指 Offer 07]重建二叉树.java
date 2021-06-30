//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 487 👎 0


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
    private TreeNode preorder(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal  = preOrder[preStart];
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftCount = index-inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = preorder(preOrder, preStart+1, preStart+leftCount, inOrder, inStart, index-1);
        root.right = preorder(preOrder, preStart+leftCount+1, preEnd, inOrder, index+1, inEnd);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return preorder(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
