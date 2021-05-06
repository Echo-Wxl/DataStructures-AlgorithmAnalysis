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
// 👍 1138 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private String ans = new String("");
    private final int SZ = 256;
    private int[] bcnt = new int[SZ];
    private int[] acnt = new int[SZ];
    private int alen = 0;
    private int blen = 0;
    private int buniq = 0;

    private int getC(String A, String B, int len) {
        // 注意这个映射函数的作用
        // 也同时完成了找到最优值的功能
        // 每次找到最优结果之后，就将它放到ans里面
        for (int i = 0; i < SZ; i++) {
            acnt[i] = 0;
        }
        int large_cnt = 0;
        for (int i = 0; i < alen; i++) {
            char c = A.charAt(i);
            if (++acnt[c] == bcnt[c]) {
                large_cnt++;
            }

            if (i < len - 1) {
                continue;
            }

            if (large_cnt >= buniq) {
                ans = A.substring(i + 1 - len, i + 1);
                return 0;
            }

            // 移除长度为len的开头的那个字符
            // 为后面的计数做准备。
            char old = A.charAt(i + 1 - len);
            if (bcnt[old] > 0 && acnt[old]-- == bcnt[old]) {
                large_cnt--;
            }
        }

        return -1;
    }

    public String minWindow(String A, String B) {
        alen = A == null ? 0 : A.length();
        blen = B == null ? 0 : B.length();

        for (int i = 0; i < SZ; i++) {
            acnt[i] = bcnt[i] = 0;
        }

        for (int i = 0; i < blen; i++) {
            bcnt[B.charAt(i)]++;
        }

        buniq = 0;
        for (int i = 0; i < SZ; i++) {
            buniq += bcnt[i] > 0 ? 1 : 0;
        }

        // 注意这里搜索的范围是[blen ~ alen + 1)
        // 从blen开始可以节省时间。因为最小的可能有效的字符串长度为
        // blen.
        int l = blen, r = alen + 1;
        while (l < r) {
            final int m = l + ((r - l) >> 1);
            final int mov = getC(A, B, m);
            if (mov < 0) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        if (l > alen)
            return "";
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
