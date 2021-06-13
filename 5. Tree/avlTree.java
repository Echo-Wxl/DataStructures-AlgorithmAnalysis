package avlTree;

import com.sun.source.tree.Tree;

public class avlTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        private int height;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    private TreeNode root;

    public avlTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 如果树中存在含有val的结点，则返回true
     *
     * @param val
     * @return
     */
    public boolean contains(int val) {
        return contains(val, root);
    }

    /**
     * 递归找到最小值
     *
     * @return
     */
    public int findMin() {
        if (isEmpty()) {
            return 0;
        } else {
            return findMin(root).val;
        }
    }

    /**
     * 迭代找到最大值
     *
     * @return
     */
    public int findMax() {
        if (isEmpty()) {
            return 0;
        } else {
            return findMax(root).val;
        }
    }

    /**
     * 插入元素
     *
     * @param val
     */
    public void insert(int val) {
        root = insert(val, root);
    }

    /**
     * 移除元素
     *
     * @param val
     */
    public void remove(int val) {
        root = remove(val, root);
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Empty Tree");
        }
        printTree(root);
    }


    private boolean contains(int val, TreeNode rt) {
        if (rt == null) {
            return false;
        }
        if (val < rt.val) {
            return contains(val, rt.left);
        } else if (val > rt.val) {
            return contains(val, rt.right);
        } else {
            return true;
        }
    }

    private TreeNode findMin(TreeNode rt) {
        if (rt == null) {
            return null;
        } else if (rt.left == null) {
            return rt;
        }
        return findMin(rt.left);
    }

    private TreeNode findMax(TreeNode rt) {
        if (rt != null) {
            while (rt.right != null) {
                rt = rt.right;
            }
        }
        return rt;
    }

    private TreeNode insert(int val, TreeNode rt) {
        if (rt == null) {
            return new TreeNode(val);
        }
        if (val < rt.val) {
            rt.left = insert(val, rt.left);
        } else if (val > rt.val) {
            rt.right = insert(val, rt.right);
        }
        return balanced(rt);
    }

    /**
     * 右旋
     *
     * @param rt
     * @return
     */
    private TreeNode rotateWithLeftChild(TreeNode rt) {
        TreeNode x = rt.left;
        rt.left = x.right;
        x.right = rt;
        rt.height = Math.max(height(rt.left), height(rt.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    /**
     * 左旋
     *
     * @param rt
     * @return
     */
    private TreeNode rotateWithRightChild(TreeNode rt) {
        TreeNode x = rt.right;
        rt.right = x.left;
        x.left = rt;
        rt.height = Math.max(height(rt.left), height(rt.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    /**
     * 先左旋rt.left，再右旋rt
     *
     * @param rt
     * @return
     */
    private TreeNode doubleWithLeftChild(TreeNode rt) {
        rt.left = rotateWithRightChild(rt.left);
        return rotateWithLeftChild(rt);
    }

    /**
     * 先右旋rt.right, 再左旋rt
     *
     * @param rt
     * @return
     */
    private TreeNode doubleWithRightChild(TreeNode rt) {
        rt.right = rotateWithRightChild(rt.right);
        return rotateWithLeftChild(rt);
    }

    private static final int ALLOWED_IMBALANCE = 1;

    /**
     * 平衡
     *
     * @param rt
     * @return
     */
    private TreeNode balanced(TreeNode rt) {
        if (rt == null) {
            return null;
        }

        if (height(rt.left) - height(rt.right) > ALLOWED_IMBALANCE) {
            if (height(rt.left.left) >= height(rt.left.right)) {
                rotateWithLeftChild(rt);
            } else {
                doubleWithLeftChild(rt);
            }
        }

        if (height(rt.right) - height(rt.left) > ALLOWED_IMBALANCE) {
            if (height(rt.right.right) >= height(rt.right.left)) {
                rotateWithRightChild(rt);
            } else {
                doubleWithRightChild(rt);
            }
        }

        rt.height = Math.max(height(rt.left), height(rt.right)) + 1;
        return rt;
    }


    private TreeNode remove(int val, TreeNode rt) {
        if (rt == null) {
            return null;
        }
        if (val < rt.val) {
            rt.left = remove(val, rt.left);
        } else if (val > rt.val) {
            rt.right = remove(val, rt.right);
        } else if (rt.left != null && rt.right != null) {
            rt.val = findMin(rt.right).val;
            rt.right = remove(rt.val, rt.right);
        } else {
            rt = (rt.left != null) ? rt.left : rt.right;
        }
        return balanced(rt);
    }

    private void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
        }
    }

    /**
     * 树的高度
     *
     * @param rt
     * @return
     */
    private int height(TreeNode rt) {
        if (rt == null) {
            return 0;
        }
        return Math.max(height(rt.left), height(rt.right)) + 1;
    }
}
