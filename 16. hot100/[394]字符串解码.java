//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 
// 👍 850 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int ptr;
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        ptr = 0;

        while (ptr < s.length()) {
            Character cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                String digits = getDigit(s);
                stack.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                stack.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);

                stack.removeLast();

                int time = Integer.parseInt(stack.removeLast());

                StringBuffer temp = new StringBuffer();
                String t = getString(sub);
                while (time-- > 0) {
                    temp.append(t);
                }
                stack.addLast(temp.toString());
            }
        }
        return getString(stack);
    }

    private String getDigit(String s) {
        StringBuffer sb = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr++));
        }
        return sb.toString();
    }

    private String getString(LinkedList<String> list) {
        StringBuffer sb = new StringBuffer();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
