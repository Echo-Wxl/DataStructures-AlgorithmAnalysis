class MyLinkedList{
    class ListNode{
        public int val = 0;
        public ListNode next = null;
        public ListNode(){}

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode dummy;
    private ListNode tail;
    private int size;

    //初始化链表
    public MyLinkedList() {
        dummy = new ListNode();
        tail = dummy;
        size = 0;
    }

    //将值为 val 的结点追加到链表尾部
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        tail.next = node;
        tail = node;
        size++;
    }

    //插入值val的新结点，使它成为链表的第一个结点
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = dummy.next;
        dummy.next = node;
        if (tail == dummy) {
            tail = node;
        }
        size++;
    }

    // 获得index索引的前一节点
    private ListNode getPrevNode(int index) {
        ListNode front = dummy.next;
        ListNode back = dummy;
        for (int i = 0; i < index && front != null; i++) {
            back = front;
            front = fornt.next;
        }
    }

    //获取链表中第index个结点的值。如果索引无效，则返回-1
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return getPrevNode(index).next.val;
    }

    // 在链表中的第 index 个结点之前添加值为 val  的结点。
    // 1. 如果 index 等于链表的长度，则该结点将附加到链表的末尾。
    // 2. 如果 index 大于链表长度，则不会插入结点。
    // 3. 如果index小于0，则在头
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        } else if (index == size) {
            addAtTail(val);
        } else if (index < 0) {
            addAtHead(val);
        } else {
            ListNode prev = getPrevNode(index);
            ListNode node = new ListNode(val);
            node.next = prev.next;
            prev.next = node;
            size++;
        }
    }

    //如果索引index有效，则删除链表中的第index个结点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode prev = getPrevNode(index);
        if (tail == prev.next) {
            tail = prev;
        }
        prev.next = prev.next.next;
        size--;
    }
}