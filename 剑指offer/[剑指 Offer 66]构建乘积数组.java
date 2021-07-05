//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 
// 👍 127 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        if (a == null || a.length <= 1) {
            return new int[0];
        }

        int sum = 1;
        int zeroNumber = 0;
        for (int x : a) {
            if (x == 0) {
                zeroNumber++;
            } else {
                sum *= x;
            }
        }

        int[] b = new int[a.length];
        if (zeroNumber > 1) {
            return b;
        }
        for (int i = 0; i < a.length; i++) {
            if (zeroNumber == 1) {
                if (a[i] == 0) {
                    b[i] = sum;
                } else {
                    b[i] =0;
                }
            } else{
                b[i] = sum / a[i];
            }
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
