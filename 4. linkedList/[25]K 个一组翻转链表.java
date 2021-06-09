//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 进阶： 
//
// 
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
// 
//
// 示例 4： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 
// 
//
// 提示： 
//
// 
// 列表中节点的数量在范围 sz 内 
// 1 <= sz <= 5000 
// 0 <= Node.val <= 1000 
// 1 <= k <= sz 
// 
// Related Topics 链表 
// 👍 1128 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode temp = new ListNode();
    private ListNode tempTail = temp;
    private int length = 0;

    private ListNode ans = new ListNode();
    private ListNode ansTail = ans;

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next;
        }
        return dummy.next;
    }

    private void append(ListNode p, int k) {
        tempTail.next = p;
        tempTail = p;
        length++;

        if (length == k) {
            ListNode cueTail = temp.next;
            ListNode curHead = reverse(temp);
            ansTail.next = curHead;
            ansTail = cueTail;

            length = 0;
            temp.next = null;
            tempTail = temp;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        while (p != null) {
            ListNode  next = p.next;
            p.next = null;
            append(p, k);
            p = next;
        }

        if (length > 0) {
            ansTail.next = temp.next;
            ansTail = tempTail;
        }
        ansTail.next = null;
        return ans.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
