//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1104 👎 0


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

    // 1. 找到链表中间的值
    private ListNode findMiddle(ListNode head) {
        ListNode s1 = head;
        ListNode s2 = head;
        ListNode pre = s1;
        while (s2 != null && s2.next != null) {
            pre = s1;
            s1 = s1.next;
            s2 = s2.next.next;
        }
        return s2 != null ? s1 : pre;
    }

    // 合并排序
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode back = middle.next;
        middle.next = null;

        ListNode i = mergeSort(head);
        ListNode j = mergeSort(back);

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (i != null || j != null) {
            if (j == null || i != null && i.val < j.val) {
                tail.next = i;
                tail = i;
                i = i.next;
            } else {
                tail.next = j;
                tail = j;
                j = j.next;
            }
        }

        tail.next = null;
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
