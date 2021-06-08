//给一非空的单词列表，返回前 k 个出现次数最多的单词。 
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 349 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Counter extends HashMap<String, Integer> {
    public int get(String k) {
        return containsKey(k)?super.get(k):0;
    }

    public void add(String k, int v) {
        put(k, get(k) + v);
        if (get(k) <= 0) {
            remove(k);
        }
    }
}
class Solution {
    class Node{
        private String val;
        private int cnt;

        public Node(String s, int c) {
            val = s;
            cnt = c;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        final int N = words==null ?0:words.length;
        if (k <= 0) {
            return null;
        }

        Counter H = new Counter();
        for (int i = 0; i < N; i++) {
            H.add(words[i], 1);
        }

        Queue<Node> Q = new PriorityQueue<>((o1, o2)->{
            if (o1.cnt != o2.cnt) {
                return o1.cnt - o2.cnt;
            }
            return o2.val.compareTo(o1.val);
        });

        for (Map.Entry<String, Integer> entry : H.entrySet()) {
            Q.add(new Node(entry.getKey(), entry.getValue()));
            while (Q.size() > k) {
                Q.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while (!Q.isEmpty()) {
            ans.add(Q.poll().val);
        }
        Collections.reverse(ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
