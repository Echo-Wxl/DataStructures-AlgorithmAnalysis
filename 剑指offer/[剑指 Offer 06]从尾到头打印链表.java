//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 159 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            ListNode next = head.next;
            stack.push(head);
            head = next;
        }

        int size = stack.size();
        int[] ans = new int[size];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop().val;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
