//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 937 👎 0


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
    private ListNode[] oddOrEven(ListNode head) {
        boolean isOdd = true;
        ListNode odd = new ListNode();
        ListNode oddTail = odd;
        ListNode even = new ListNode();
        ListNode evenTail = even;
        while (head != null) {
            if (isOdd) {
                oddTail.next = head;
                oddTail = head;
            } else {
                evenTail.next = head;
                evenTail = head;
            }
            isOdd = !isOdd;
            head = head.next;
        }
        oddTail.next =null;
        evenTail.next  = null;
        return new ListNode[]{odd.next, even.next};
    }

    private ListNode mergeList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (a != null || b != null) {
            if (b != null) {
                tail.next = b;
                tail = b;
                b = b.next;
            }
            if (a != null) {
                tail.next = a;
                tail = a;
                a = a.next;
            }
        }
        tail.next = null;
        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode[] oddOrEven = oddOrEven(head);
        return mergeList(oddOrEven[0],oddOrEven[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
