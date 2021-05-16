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
// 👍 1785 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 方法一：回溯+DFS
    /*
    private void backTrace(int n, int i, int lcnt, int rcnt, StringBuffer path, List<String> ans) {
        if (i == (n + n) && lcnt == rcnt) {
            ans.add(path.toString());
        } else {
            if (lcnt >= rcnt && lcnt < n) {
                path.append("(");
                backTrace(n, i+1, lcnt+1, rcnt, path, ans);
                path.setLength(path.length()-1);
            }
            if (lcnt > rcnt) {
                path.append(")");
                backTrace(n, i+1, lcnt, rcnt+1, path, ans);
                path.setLength(path.length()-1);
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }

        StringBuffer path = new StringBuffer();
        backTrace(n, 0, 0, 0, path, ans);
        return ans;
    }
     */

    // 方式二：BFS
    /*
    class Node{
        public String path;
        public int lcnt;
        public int rcnt;

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
            int qSize = Q.size();
            for (int i = 0; i < qSize; i++) {
                cur = Q.poll();
                if (cur.path.length() == n + n && cur.lcnt == cur.rcnt) {
                    ans.add(cur.path);
                    continue;
                }
                if (cur.lcnt >= cur.rcnt && cur.lcnt < n) {
                    Node next = new Node(cur.path+"(", cur.lcnt+1, cur.rcnt);
                    Q.offer(next);
                }
                if (cur.lcnt > cur.rcnt) {
                    Node next = new Node(cur.path + ")", cur.lcnt, cur.rcnt + 1);
                    Q.offer(next);
                }
            }
        }
        return ans;
    }
     */

    // 方式三：DP
    private List<String> first = new ArrayList<>();
    private List<List<String>> G = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }
        if (G.size() == 0) {
            first.add("");
            G.add(first);
        }

        while (G.size() <= n) {
            List<String> cur = new ArrayList<>();
            for (int i = 0; i < G.size(); i++) {
                List<String> L = G.get(i);
                List<String> R = G.get(G.size()-i-1);
                for (String l : L) {
                    for (String r : R) {
                        cur.add("("+l+")"+r);
                    }
                }
            }
            G.add(cur);
        }
        return G.get(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
