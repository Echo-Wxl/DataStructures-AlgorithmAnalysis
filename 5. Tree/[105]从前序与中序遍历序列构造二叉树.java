//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder =[3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 996 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/**
 * 思路：
 * 1. 前序遍历的的第一个元素就是root结点
 * 2. 找到中序遍历root结点的索引位置
 * 3. 创建root结点
 * 4. root.left = bulid(preorder, preStart+1, preStart+leftCount,inorder, inStart, index-1);
 * 5. root.right = bulid(preorder, preStart+leftCount+1, preEnd, inorder, index+1, inEnd);
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return preOrder(preorder, 0, preorder.length -1,
                inorder, 0, inorder.length-1);
    }

    private TreeNode preOrder(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int leftCount = index - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = preOrder(preorder, preStart + 1, preStart + leftCount,
                inorder, inStart, index - 1);
        root.right = preOrder(preorder, preStart + leftCount + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
