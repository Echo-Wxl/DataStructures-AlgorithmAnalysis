/*
【题目】字符串中只有字符'('和')'。合法字符串需要括号可以配对。比如：

输入："()"

输出：true

解释：()，()()，(())是合法的。)(，()(，(()是非法的。
 */
class Solution{
    /*
    使用栈，时间和空间复杂度都是O(n)
    public boolean isValid(String string) {
        final int N = string== null ?0:string.length();

        if (N == 0 || (N & 0x01) == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            Character cur = string.charAt(i);
            if (cur == '(') {
                stack.push(cur);
            } else if (cur == ')') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

     */

    // 深度扩展:
    // 如果栈中存放的元素都是一样的，则只需计数即可
    // 时间复杂度O(n)，空间复杂度O(1)
    public boolean isValid(String str) {
        final int N = str==null ? 0:str.length();
        if (N == 0 || (N & 0x01) == 1) {
            return false;
        }

        int leftCount = 0;
        for (int i = 0; i < N; i++) {
            Character cur = str.charAt(i);
            if (cur == '(') {
                leftCount++;
            } else if (cur == ')') {
                if (leftCount == 0) {
                    return false;
                }
                leftCount--;
            }
        }
        return leftCount == 0;
    }

    // 广度扩展：leetcode-20 有效括号20

}