//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 单调栈 
// 👍 1493 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*
1。 暴力求解
class Solution {
    private int minHeight(int[] arr, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            min = Math.min(arr[k], min);
        }
        return min;
    }
    public int largestRectangleArea(int[] heights) {
        final int N = heights == null ? 0:heights.length;

        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                ans = Math.max(ans, minHeight(heights, i, j) * (j - i + 1));
            }
        }
        return ans;
    }
}
 */

/*
class Solution{
    private int log2(int N) {
        return (int) (Math.log(N) / Math.log(2));
    }

    private int[][] createST(int N) {
        final int powerOf2 = log2(N);

        int[][] st = new int[N][powerOf2 + 1];
        for (int i = 0; i < N; i++) {
            st[i] = new int[powerOf2 + 1];
        }
        return st;
    }

    private void buildST(int[] A, int[][] st) {
        final int N = A==null ? 0:A.length;
        for (int i = 0; i < N; i++) {
            st[i][0] = A[i];
        }

        for (int i = 1; (1<<i) <= N; i++) {
            for (int j = 0; (j+(1<<i)) <=N ; j++) {
                st[j][i] = Math.min(st[j][i-1], st[j+(1<<(i-1))][i - 1]);
            }
        }
    }

    private int minHeight(int[][] st, int l, int r) {
        int len = r-l+1;
        int j = log2(len);
        return Math.min(st[l][j], st[r - (1 << j) + 1][j]);
    }

    public int largestRectangleArea(int[] heights) {
        final int N = heights==null ?0: heights.length;

        int[][] st = createST(N);
        buildST(heights, st);

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                ans = Math.max(ans, minHeight(st, i, j) * (j - i + 1));
            }
        }
        return ans;
    }
}
 */

    class Solution {
        // 这里得到一个区域里面的最大矩形面积
        // 这个区间域为[b, e)
        // 注意e是取不到的
        private int getRangeMaxArea(int[] heights, int b, int e) {
            // 如果为空区间
            if (b >= e) {
                return 0;
            }
            // 如果区间中只有一个元素
            if (b + 1 == e) {
                return heights[b];
            }
            // 如果有多个元素。那么找到范围里面的最小值
            // 如果有多个最小值，那么我们就找离中心最近的那个，尽量把区域进行等分
            int mid = b + ((e-b) >> 1);
            int minIndex = b;
            for (int i = b + 1; i < e; i++) {
                if (heights[i] < heights[minIndex]) {
                    minIndex = i;
                } else if (heights[i] == heights[minIndex]) {
                    // 多个最小值，那么谁离mid更近，我们用谁
                    if (Math.abs(mid - i) < Math.abs(mid - minIndex)) {
                        minIndex = i;
                    }
                }
            }
            // 在使用 最小值 情况下的面积
            int useMinIndexArea = heights[minIndex] * (e - b);
            // 不用 minIndex 那么就会把区间分为两部分
            int leftMaxArea = getRangeMaxArea(heights, b, minIndex);
            int rightMaxArea = getRangeMaxArea(heights, minIndex + 1, e);
            return Math.max(useMinIndexArea,
                    Math.max(leftMaxArea, rightMaxArea));
        }
        public int largestRectangleArea(int[] heights) {
            final int N = heights == null ? 0 : heights.length;
            return getRangeMaxArea(heights, 0, N);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
