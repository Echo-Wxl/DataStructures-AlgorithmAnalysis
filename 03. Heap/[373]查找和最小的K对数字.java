//给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。 
//
// 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。 
//
// 示例 1: 
//
// 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
// Related Topics 堆 
// 👍 187 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Node{
        private int i;
        private int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    // 方法一：时间复杂度O(n2)
    /*
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        final int M = nums1.length,  N = nums2.length;
        Queue<Node> Q = new PriorityQueue<>((o1, o2) -> nums1[o2.i] + nums2[o2.j] - nums1[o1.i] - nums2[o1.j]);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Q.add(new Node(i, j));
                while (Q.size() > k) {
                    Q.poll();
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!Q.isEmpty()) {
            Node p = Q.poll();
            ans.add(Arrays.asList(nums1[p.i], nums2[p.j]));
        }
        return ans;
    }
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return new ArrayList<>();
        }

        final int N = nums1.length;
        final int M = nums2.length;

        Queue<Node> Q = new PriorityQueue<>((o1, o2) -> nums1[o1.i] + nums2[o1.j] - nums1[o2.i] - nums2[o2.j]);

        for (int i = 0; i < N; i++) {
            Q.add(new Node(i, 0));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k && !Q.isEmpty(); i++) {
            Node p = Q.poll();
            ans.add(Arrays.asList(nums1[p.i], nums2[p.j]));
            if (p.j + 1 < M) {
                Q.add(new Node(p.i, p.j+1));
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
