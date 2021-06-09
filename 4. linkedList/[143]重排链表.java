//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 593 👎 0


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
    private ListNode findMiddleNode(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode s1 = head;
        ListNode s2 = head;
        ListNode pre = dummy;
        while (s2 != null && s2.next != null) {
            s2 = s2.next.next;
            pre = s1;
            s1 = s1.next;
        }
        return s2 == null ? pre :s1;
    }

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

    public void reorderList(ListNode head) {
        ListNode mid = findMiddleNode(head);
        ListNode back = mid.next;
        mid.next = null;

        ListNode front = head;
        back = reverse(back);

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (front != null || back != null) {
            if (front != null) {
                tail.next = front;
                tail = front;
                front = front.next;
            }
            if (back != null) {
                tail.next = back;
                tail = back;
                back = back.next;
            }
        }
        tail.next = null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
