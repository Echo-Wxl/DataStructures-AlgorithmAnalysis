//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 
// 👍 289 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean preOrder(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int index = i;
        while (postorder[index] < postorder[j]) {
            index++;
        }

        int rootIndex = index;
        while (postorder[index] > postorder[j]) {
            index++;
        }
        return index == j && preOrder(postorder, i, rootIndex-1)&&preOrder(postorder, rootIndex, j-1);
    }
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return preOrder(postorder, 0, postorder.length-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
