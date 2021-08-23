//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/ 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 
// 👍 157 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    Queue<Integer> upperQ; // 大顶堆，保存较小的一半数
    Queue<Integer> lowerQ; // 小顶堆，保存较大的一半数
    /** initialize your data structure here. */
    public MedianFinder() {
        upperQ = new PriorityQueue<>((o1, o2)->o2-o1);
        lowerQ = new PriorityQueue<>((o1, o2)->o1-o2);
    }
    
    public void addNum(int num) {
        if (upperQ.size() == lowerQ.size()) {
            upperQ.offer(num);
            lowerQ.offer(upperQ.poll());
        } else {
            lowerQ.offer(num);
            upperQ.offer(lowerQ.poll());
        }
    }
    
    public double findMedian() {
        if (upperQ.size() == lowerQ.size()) {
            return (upperQ.peek() + lowerQ.peek()) / 2.0;
        } else {
            return lowerQ.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
