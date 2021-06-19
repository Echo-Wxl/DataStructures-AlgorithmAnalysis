/*
【题目】从上到下按层打印二叉树，同一层结点按从左到右的顺序打印，每一层打印到一行。

输出：[[3], [9, 8], [6, 7]]
 */

class Solution{
    /*
    使用队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while (Q.size()>0) {
            int qSize = Q.size();
            List<Integer> temp = new LinkedList<>();
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
            ans.add(temp);
        }
        return ans;
    }

     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        List<TreeNode> curList = new LinkedList<>();
        if (root != null) {
            curList.add(root);
        }
        while (curList.size() > 0) {
            List<TreeNode> nextList = new LinkedList<>();
            List<Integer> curVal = new LinkedList<>();
            for (TreeNode curNode : curList) {
                curVal.add(curNode.val);
                if (curNode.left != null) {
                    nextList.add(curNode.left);
                }
                if (curNode.right != null) {
                    nextList.add(curNode.right);
                }
            }
            ans.add(curVal);
            curList = nextList;
        }
        return ans;
    }
}