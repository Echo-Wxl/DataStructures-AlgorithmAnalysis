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
            for (int j = 0; j < G.size(); j++) {
                List<String> L = G.get(j);
                List<String> R = G.get(G.size() - j - 1);
                for (String l: L) {
                    for (String r: R) {
                        cur.add("(" + l + ")" + r);
                    }
                }
            }
            G.add(cur);
        }

        return G.get(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
