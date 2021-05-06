//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 673 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int getC(long x, long m) {
        if (m * m < x) {
            return -1;
        } else if (m * m == x) {
            return 0;
        }
        return 1;
    }
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            final int m = l + ((r-l)>>1);
            final int mov = getC(x, m);
            if (mov < 0) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l * l == x) {
            return l;
        }
        return l - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
