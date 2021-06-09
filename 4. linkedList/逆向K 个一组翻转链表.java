/*
给定一个链表，从链表尾部开始，k 个一组进行反转，如果左边的分组不足 k 个，那么不反转。返回反转之后的链表。

输入：A = [1, 2, 3, 4, 5], k = 2

输出：[1, 3, 2, 5, 4]

解释：注意是从链表的尾部开始k个一组的。所以这里是[1], [2, 3], [4, 5]这样分组来进行反转。
 */

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
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }

    private void append(ListNode p, int k) {
        tempTail.next = p;
        tempTail = p;
        length++;

        if (length == k) {
            ListNode curTail = temp.next;
            ListNode curHead = reverse(temp);

            ansTail.next = curHead;
            ansTail = curTail;

            length = 0;
            temp.next = null;
            tempTail = temp;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode head = reverse(head);

        ListNode p = head;
        while (p != null) {
            ListNode next = p.next;
            p.next = null;
            append(p, k);
            p = next;
        }

        if (length > 0) {
            ansTail.next = tmep.next;
            ansTail = tempTail;
        }
        ansTail.next = null;

        return reverse(ans.next);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
