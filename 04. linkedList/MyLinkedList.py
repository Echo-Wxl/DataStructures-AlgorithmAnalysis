class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class MyLinkedList:
    def __init__(self):
        self.dummy = ListNode()
        self.tail = self.dummy
        self.length = 0

    def add_at_tail(self, val):
        self.tail.next = ListNode(val)
        self.tail = self.tail.next
        self.length += 1

    def add_at_head(self, val):
        cur_node = ListNode(val)
        cur_node.next = self.dummy.next
        self.dummy.next = cur_node

        if self.dummy == self.tail:
            self.tail = cur_node
        self.length += 1

    def get(self, index):
        pre_node = self._get_pre_node(index)
        return pre_node.next.val

    def add_at_index(self, index, val):
        if index > self.length:
            return
        elif index == self.length:
            self.add_at_tail(val)
        elif index <= 0:
            self.add_at_head(val)
        else:
            node_pre = self._get_pre_node(index)
            node_cur = ListNode(val, node_pre.next)
            node_pre.next = node_cur
        self.length += 1

    def delete_at_index(self, index):
        if index < 0 or index >= self.length:
            return

        node_pre = self._get_pre_node(index)

        if node_pre.next == self.tail:
            self.tail = node_pre

        node_pre.next = node_pre.next.next
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