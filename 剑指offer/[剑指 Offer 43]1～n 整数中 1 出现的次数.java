//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。 
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 递归 数学 动态规划 
// 👍 195 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int contains(int x) {
        int count = 0;
        while (x > 0) {
            if (x % 10 == 1) {
                count++;
            }
            x /= 10;
        }
        return count;
    }
    public int countDigitOne(int n) {
        int dp_pre = 0, dp_cur = 0;
        for (int i = 1; i <= n; i++) {
            int count = contains(i);
            dp_cur = dp_pre + count;
            dp_pre = dp_cur;
        }
        return dp_cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
