//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 248 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k <= 0 || arr == null || arr.length == 0) {
            return new int[0];
        }

        Queue<Integer> Q = new PriorityQueue<>((o1, o2)->o2-o1);
        for (int x : arr) {
            Q.offer(x);
            while (Q.size() > k) {
                Q.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while (Q.size() > 0) {
            ans[i++] = Q.poll();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
