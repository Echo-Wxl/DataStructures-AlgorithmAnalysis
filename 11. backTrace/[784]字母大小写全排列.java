//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法 
// 👍 270 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void backTrace(String A, int i, StringBuffer box, List<String> ans) {
        final int N = A ==null ?0:A.length();
        if (i == N) {
            ans.add(box.toString());
        }
        if (i >= N) {
            return;
        }
        Character ch = A.charAt(i);
        if (Character.isDigit(ch)) {
            box.append(ch);
            backTrace(A, i + 1, box, ans);
            box.setLength(box.length()-1);
        } else {
            box.append(Character.toLowerCase(ch));
            backTrace(A, i+1, box, ans);
            box.setLength(box.length()-1);

            box.append(Character.toUpperCase(ch));
            backTrace(A, i+1, box, ans);
            box.setLength(box.length()-1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        StringBuffer box = new StringBuffer();
        backTrace(s, 0, box, ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
