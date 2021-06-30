//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 139 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    private Stack<Integer> stack;
    private int minData;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minData = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= minData) {
            stack.push(minData);
            minData = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop() == minData) {
            minData = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return minData;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)
