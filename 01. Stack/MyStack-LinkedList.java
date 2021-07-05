/*
链表实现栈
 */
public class MyStack<AnyType> {
    private int theSize;
    private Node<AnyType> head;
    private Node<AnyType> tail;


    public MyStack() {
    }


    private static class Node<AnyType> {
        private AnyType data;
        private Node<AnyType> next;


        public Node(AnyType x, Node<AnyType> n) {
            data = x;
            next = n;
        }
    }


    public int size() {
        return theSize;
    }


    public void push(AnyType data) {
        Node<AnyType> newNode = new Node<AnyType>(data, null);
        if (size() == 0) {
            head = newNode;
            tail = newNode;
            theSize++;
        } else {
            newNode.next = head;
            head = newNode;
            theSize++;
        }
    }


    public AnyType pop() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("empty");
        }
        AnyType item = head.data;
        head = head.next;
        theSize--;
        return item;
    }


    public AnyType top() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("empty");
        }
        return head.data;
    }
}

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<String>();


        myStack.push("a");
        myStack.push("b");
        myStack.push("c");


        System.out.println(myStack.size());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
    }
}