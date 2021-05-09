//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1144 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        final int slen = s==null ? 0:s.length();
        final int tlen = t==null ? 0:t.length();

        int[] tcnt = new int[256];
        int tCount = 0;
        for (int i = 0; i < tlen; i++) {
            tcnt[t.charAt(i)]++;
            if (tcnt[t.charAt(i)] == 1) {
                tCount++;
            }
        }

        int left = -1;
        int ans = slen+1;
        int[] scnt = new int[256];
        int equalCount = 0;
        int start = 0;
        for (int i = 0; i < slen; i++) {
            Character ch = s.charAt(i);
            scnt[ch]++;
            if (scnt[ch] == tcnt[ch]) {
                equalCount++;
            }
            while (equalCount > tCount) {
                if (ans > i - left) {
                    start = left+1;
                    ans = i -left;
                }
                Character rm = s.charAt(++left);
                if (scnt[rm] == tcnt[rm]) {
                    equalCount--;
                }
                scnt[rm]--;
            }
        }
        return ans<=N? s.substring(start, start+ans):new String("");
    }

}
//leetcode submit region end(Prohibit modification and deletion)
