//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 
// 👍 370 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    private void backTrace(char[] s, int i, List<String> ans) {
        if (i == s.length) {
           String temp = new String(s);
           ans.add(temp);
        }
        if (i >= s.length) {
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int j = i; j < s.length; j++) {
            if (!set.contains(s[j])) {
                swap(s, i, j);
                backTrace(s, i+1, ans);
                swap(s, i, j);
                set.add(s[j]);
            }
        }
    }
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[]{};
        }
        List<String> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        backTrace(arr, 0, ans);
        return ans.toArray(new String[ans.size()]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
