# 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
# /引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
# 
#  在链表类中实现这些功能： 
# 
#  
#  get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
#  addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
#  addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
#  addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
# 到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
#  deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
#  
# 
#  
# 
#  示例： 
# 
#  
# MyLinkedList linkedList = new MyLinkedList();
# linkedList.addAtHead(1);
# linkedList.addAtTail(3);
# linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
# linkedList.get(1);            //返回2
# linkedList.deleteAtIndex(1);  //现在链表是1-> 3
# linkedList.get(1);            //返回3
#  
# 
#  
# 
#  提示： 
# 
#  
#  0 <= index, val <= 1000 
#  请不要使用内置的 LinkedList 库。 
#  get, addAtHead, addAtTail, addAtIndex 和 deleteAtIndex 的操作次数不超过 2000。 
#  
# 
#  Related Topics 设计 链表 👍 742 👎 0


# leetcode submit region begin(Prohibit modification and deletion)

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class MyLinkedList(object):

    def __init__(self):
        self.dummy = ListNode()
        self.tail = self.dummy
        self.length = 0

    def get(self, index):
        """
        :type index: int
        :rtype: int
        """
        if index < 0 or index >= self.length:
            return -1
        pre_node = self._get_pre_node(index)
        return pre_node.next.val

    def addAtHead(self, val):
        """
        :type val: int
        :rtype: None
        """
        head = ListNode(val)
        head.next = self.dummy.next
        self.dummy.next = head
        if self.dummy == self.tail:
            self.tail = head
        self.length += 1

    def addAtTail(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.tail.next = ListNode(val)
        self.tail = self.tail.next
        self.length += 1

    def addAtIndex(self, index, val):
        """
        :type index: int
        :type val: int
        :rtype: None
        """
        if index > self.length:
            return
        elif index <= 0:
            self.addAtHead(val)
        elif index == self.length:
            self.addAtTail(val)
        else:
            pre_node = self._get_pre_node(index)
            cur_node = ListNode(val, pre_node.next)
            pre_node.next = cur_node
            self.length += 1

    def deleteAtIndex(self, index):
        """
        :type index: int
        :rtype: None
        """
        if index < 0 or index >= self.length:
            return

        pre_node = self._get_pre_node(index)
        if pre_node.next == self.tail:
            self.tail = pre_node
        pre_node.next = pre_node.next.next
        self.length -= 1

    def _get_pre_node(self, index):
        front = self.dummy.next
        back = self.dummy
        i = 0
        while i < index and front is not None:
            back = front
            front = front.next
            i += 1
        return back

# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)
# leetcode submit region end(Prohibit modification and deletion)
