//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 347 👎 0

/*
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        final int s1len = s1== null ? 0:s1.length();
        final int s2len = s2== null ? 0:s2.length();
        int[] s1cnt = new int[256];
        for (int i = 0; i < s1len; i++) {
            s1cnt[s1.charAt(i)]++;
        }

        int[] s2cnt = new int[256];
        int left = -1;
        for (int i = 0; i < s2len; i++) {
            Character c = s2.charAt(i);
            s2cnt[c]++;
            if (i - left < s1len) {
                continue;
            }

            boolean same = true;
            for (int j = 0; j < 256 && same; j++) {
                same = s1cnt[j] == s2cnt[j];
            }

            if (same) {
                return true;
            }

            left++;
            s2cnt[s2.charAt(left)]--;
        }
        return false;
    }
}
 */


//class Counter extends HashMap<Character, Integer>{
//    public int get(Character k) {
//        return containsKey(k)? super.get(k):0;
//    }
//
//    public void add(Character k, int v) {
//        put(k, get(k)+v);
//        if (get(k) <= 0) {
//            remove(k);
//        }
//    }
//}

//class Solution {
//    public boolean checkInclusion(String s1, String s2) {
//        final int s1len = s1== null ? 0:s1.length();
//        final int s2len = s2== null ? 0:s2.length();
//        Counter s1cnt = new Counter();
//        for (int i = 0; i < s1len; i++) {
//            s1cnt.add(s1.charAt(i), 1);
//        }
//
//        Counter s2cnt = new Counter();
//        int left = -1;
//        int equals = 0;
//        for (int i = 0; i < s2len; i++) {
//            Character c = s2.charAt(i);
//            s2cnt.add(c, 1);
//            if (s1cnt.get(c) == s2cnt.get(c)) {
//                equals++;
//            }
//            if (i - left < s1len) {
//                continue;
//            }
//
//            if (equals == s1cnt.size()) {
//                return true;
//            }
//            left++;
//            Character rm = s2.charAt(left);
//            if (s1cnt.get(rm) == s2cnt.get(rm)) {
//                equals--;
//            }
//            s2cnt.add(rm, -1);
//        }
//        return false;
//    }
//}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        final int s1len = s1 == null ? 0:s1.length();
        final int s2len = s2 == null ? 0:s2.length();
        int[] s1cnt = new int[256];
        int s1count = 0;
        for (int i = 0; i < s1len; i++) {
            s1cnt[s1.charAt(i)]++;
            if (s1cnt[s1.charAt(i)] == 1) {
                s1count++;
            }
        }
        int left = -1;
        int equals = 0;
        int[] s2cnt = new int[256];
        for (int i = 0; i < s2len; i++) {
            Character ch = s2.charAt(i);
            s2cnt[ch]++;
            if (s1cnt[ch] == s2cnt[ch]) {
                equals++;
            }
            if (i - left < s1len) {
                continue;
            }
            if (equals == s1count) {
                return true;
            }

            Character rm = s2.charAt(++left);
            if (s1cnt[rm] == s2cnt[rm]) {
                equals --;
            }
            s2cnt[rm]--;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)