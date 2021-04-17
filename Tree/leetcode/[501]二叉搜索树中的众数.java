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
// 👍 294 👎 0


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
 * 思路：
 * 这样一颗二叉搜索树的中序遍历序列是 \{ -1, 0, 0, 1, 2, 2 \}{−1,0,0,1,2,2}。我们可以发现重复出现的数字一定是一个连续出现的，
 * 例如这里的 00 和 22，它们都重复出现了，并且所有的 00 都集中在一个连续的段内，所有的 22 也集中在一个连续的段内。我们可以顺序扫描中序遍历序列
 * ，用 base 记录当前的数字，用 count 记录当前数字重复的次数，用 maxCount 来维护已经扫描过的数当中出现最多的那个数字的出现次数，
 * 用 answer 数组记录出现的众数。每次扫描到一个新的元素：
 *
 * 首先更新 base 和 count:
 *      如果该元素和 base 相等，那么 count 自增 11；
 *      否则将 base 更新为当前数字，count 复位为 11。
 * 然后更新 maxCount：
 *      如果  count=maxCount，那么说明当前的这个数字（base）出现的次数等于当前众数出现的次数，将 base 加入 answer 数组；
 *      如果  count>maxCount，那么说明当前的这个数字（base）出现的次数大于当前众数出现的次数，因此，我们需要将 maxCount 更新为 count，清空 answer 数组后将 base 加入 answer 数组。
 *
 *
 */
class Solution {
    List<Integer> answer = new ArrayList<>();
    int base, count, maxCount;

    public int[] findMode(TreeNode root) {
        midOrder(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void midOrder(TreeNode root) {
        if (root != null) {
            midOrder(root.left);
            update(root.val);
            midOrder(root.right);
        }
    }

    public void update(int val) {
        if (base == val) {
            count ++;
        }else{
            base = val;
            count = 1;
        }

        if (count == maxCount) {
            answer.add(val);
        } else if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
