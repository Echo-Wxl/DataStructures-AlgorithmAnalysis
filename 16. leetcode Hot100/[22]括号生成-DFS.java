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
    private void backTrace(int n, int i, int lcnt, int rcnt, StringBuffer sb, List<String> ans) {
        if (i == (n + n) && lcnt == rcnt) {
            ans.add(sb.toString());
        } else {
            if (lcnt >= rcnt && lcnt < n) {
                sb.append('(');
                backTrace(n, i + 1, lcnt + 1, rcnt, sb, ans);
                sb.setLength(sb.length() - 1);
            }
            if (lcnt > rcnt) {
                sb.append(')');
                backTrace(n, i+1, lcnt, rcnt+1, sb, ans);
                sb.setLength(sb.length() - 1);
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0) {
            return ans;
        }
        StringBuffer box = new StringBuffer();
        backTrace(n, 0, 0, 0, box, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
