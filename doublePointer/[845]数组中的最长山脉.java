//我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”： 
//
// 
// B.length >= 3 
// 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
//[B.length - 1] 
// 
//
// （注意：B 可以是 A 的任意子数组，包括整个数组 A。） 
//
// 给出一个整数数组 A，返回最长 “山脉” 的长度。 
//
// 如果不含有 “山脉” 则返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,4,7,3,2,5]
//输出：5
//解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 输入：[2,2,2]
//输出：0
//解释：不含 “山脉”。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 双指针 
// 👍 187 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestMountain(int[] arr) {
        final int N = arr==null ? 0:arr.length;
        if (N < 3) {
            return 0;
        }
        int left = -1;
        int ans = 0;
        int preValue = arr[0];
        int status = -1;
        for (int i = 1; i < N; i++) {
            final int x = arr[i];
            if (status == -1) {
                if (x > preValue) {
                    status = 0;
                } else {
                    left = i - 1;
                }
            } else {
                if (status == 0) {
                    if (x > preValue) {
                    } else if (x == preValue) {
                        status = -1;
                        left = i - 1;
                    } else {
                        status = 1;
                    }
                } else {
                    if (x < preValue) {
                    } else if (x == preValue) {
                        status = -1;
                        left = i-1;
                    } else {
                        status =0;
                        left = i-2;
                    }
                }
            }
            preValue = x;
            if (status == 1) {
                ans = Math.max(ans, i-left);
            }
        }
        return ans>=3?ans:0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
