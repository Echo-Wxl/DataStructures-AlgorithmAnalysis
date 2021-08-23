//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1303 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    final String[] ds = new String[]{
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    private void backTrace(String A, int i, StringBuffer box, List<String> ans) {
        final int N = A==null ? 0:A.length();
        // 什么状态是我们想要的
        if (box.length() == N) {
            ans.add(box.toString());
        }
        // 什么条件退出
        if (i >= N) {
            return;
        }
        // 每个宝石怎么处理
        String str = ds[(int) A.charAt(i)-'0'];
        for (int j = 0; j < str.length(); j++) {
            box.append(str.charAt(j));
            backTrace(A, i+1, box, ans);
            box.deleteCharAt(box.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        StringBuffer box = new StringBuffer();
        backTrace(digits, 0, box, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
