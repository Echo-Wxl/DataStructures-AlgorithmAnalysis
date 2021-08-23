//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 堆 哈希表 
// 👍 769 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Counter extends HashMap<Integer, Integer>{
    public int get(Integer k) {
        return containsKey(k) ? super.get(k) : 0;
    }

    public void add(Integer k, int v) {
        put(k, get(k) + v);
        if (get(k) <= 0) {
            remove(k);
        }
    }
}
class Solution {
    class Node{
        private int val=0;
        private int cnt=0;

        public Node(int v, int c) {
            val = v;
            cnt = c;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        final int N = nums == null ? 0:nums.length;
        if (k <= 0) {
            return new int[0];
        }
        int[] ans = new int[k];
        Counter H = new Counter();
        for (int i = 0; i < N; i++) {
            H.add(nums[i], 1);
        }

        Queue<Node> Q = new PriorityQueue<>((o1, o2)->o1.cnt - o2.cnt);

        for (Map.Entry<Integer, Integer> e : H.entrySet()) {
            Q.add(new Node(e.getKey(), e.getValue()));
            while (Q.size() > k) {
                Q.poll();
            }
        }

        int i = 0;
        while (!Q.isEmpty()) {
            ans[i++] = Q.poll().val;
        }
        Arrays.sort(ans);
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
