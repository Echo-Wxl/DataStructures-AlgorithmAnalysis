//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 468 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Counter extends HashMap<String, Integer> {
    public int get(String str) {
        return containsKey(str)?super.get(str):0;
    }

    public void add(String str, int v) {
        put(str, get(str)+v);
        if (get(str) <= 0) {
            remove(str);
        }
    }
}
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Counter H = new Counter();
        int wordLength = 0;
        for (String w : words) {
            H.add(w, 1);
            wordLength = w.length();
        }
        List<Integer> ans = new ArrayList<>();
        for (int start = 0; start < wordLength; start++) {
            Counter R = new Counter();
            int left = start - wordLength;
            int equalCount = 0;
            int windowSize = 0;
            for (int i = start; i + wordLength < s.length(); i += wordLength) {
                String tmp = s.substring(i,i+wordLength);
                R.add(tmp, 1);
                if (R.get(tmp) == H.get(tmp)) {
                    equalCount++;
                }
                windowSize++;
                if (windowSize < words.length) {
                    continue;
                }
                if (equalCount == H.size()) {
                    ans.add(left+wordLength);
                }

                left += wordLength;
                String rm = s.substring(left, left + wordLength);
                if (R.get(rm) == H.get(rm)) {
                    equalCount--;
                }
                R.add(rm, -1);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
