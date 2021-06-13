
class Solutin{
    /*
    计算一颗普通二叉树的结点数目
    */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    /*
    计算一棵满二叉树，节点总数就和树的高度呈指数关系，时间复杂度 O(logN)
     */
    public int countNodes(TreeNode root) {
        int h = 0;
        // 计算树的高度
        while (root != null) {
            root = root.left;
            h++;
        }
        // 节点总数就是 2^h - 1
        return (int)Math.pow(2, h)-1;
    }

    /*
    计算一个完全二叉树的结点数目，普通和完全的结合体
     */
    public int countNodes(TreeNode root) {
        TreeNode left = root, right = root;
        int heightLeft = 0, heightRight = 0;

        while (left != null) {
            left = left.left;
            heightLeft++;
        }
        while (right != null) {
            right = right.right;
            heightRight++;
        }

        if (heightLeft == heightRight) {
            return (int)Math.pow(2, heightLeft)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}

