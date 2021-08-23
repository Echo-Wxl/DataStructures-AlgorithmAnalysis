//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1839 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Node{
        public String path;
        public int lcnt = 0;
        public int rcnt = 0;

        public Node(){}

        public Node(String p, int l, int r) {
            path = p;
            lcnt = l;
            rcnt = r;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }

        Queue<Node> Q = new LinkedList<>();
        Node cur = new Node("(", 1, 0);
        Q.offer(cur);

        while (!Q.isEmpty()) {
            final int qSize = Q.size();
            for (int i = 0; i < qSize; i++) {
                cur = Q.poll();
                if (cur.path.length() == (n + n) && cur.lcnt == cur.rcnt) {
                    ans.add(cur.path);
                    continue;
                }
                if (cur.lcnt >= cur.rcnt && cur.lcnt < n) {
                    Q.offer(new Node(cur.path+"(", cur.lcnt+1, cur.rcnt));
                }
                if (cur.lcnt > cur.rcnt) {
                    Q.offer(new Node(cur.path+")", cur.lcnt, cur.rcnt + 1));
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
