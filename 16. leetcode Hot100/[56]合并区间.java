//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 921 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        final int N = intervals== null ?0: intervals.length;
        Arrays.sort(intervals, (o1, o2)->{
            if (o1[0] != o2[0]) {
                return o1[0] == o2[0] ? 0 : (o1[0] < o2[0] ? -1 : 1);
            }
            return o1[1] == o2[1] ? 0 : (o1[1] < o2[1] ? -1 : 1);
        });

        List<int[]> ans = new ArrayList<int[]>();
        for (int i = 0; i < N; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            int ansSize = ans.size();
            if (ansSize == 0 || ans.get(ansSize - 1)[1] < start) {
                ans.add(new int[]{start, end});
            } else {
                ans.get(ansSize - 1)[1] = Math.max(end, ans.get(ansSize - 1)[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
