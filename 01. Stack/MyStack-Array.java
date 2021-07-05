/*** 线性表实现栈* @param <AnyType>*/
public class MyStackArray<AnyType> {
    public static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private AnyType[] theItem;

    public MyStackArray() {
        doClear();
    }

    public int size() {
        return theSize + 1;
    }

    private void doClear() {
        theSize = -1;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size()) return;
        AnyType[] old = theItem;
        theItem = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItem[i] = old[i];
        }
    }

    public void push(AnyType newVal) {
        if (theItem.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        theSize++;
        theItem[theSize] = newVal;
    }

    public AnyType pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty");
        }
        AnyType item = theItem[theSize];
        theSize--;
        return item;
    }

    public AnyType top() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty");
        }
        return theItem[theSize];
    }
}

/*
测试
 */
public class MyStackArrayTest {
    public static void main(String[] args) {
        MyStackArray<String> myStack = new MyStackArray<>();


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