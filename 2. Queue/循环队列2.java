/*
使用 k+1 个元素的空间，两个变量 front, rear 来控制循环队列的使用
 */

class MyCircularQueue{
    private int[] Q = null;
    private int capacity;
    private int front = 0;
    private int rear = 0;


    public MyCircularQueue(){}

    public MyCircularQueue(int k) {
        capacity = k+1;
        Q = new int[capacity + 1];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        Q[rear] = value;
        rear = (rear+1)%capacity;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front+1)%capacity;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : Q[front];
    }

    public int Rear() {
        int tail = (rear-1+capacity)%capacity;
        return isEmpty() ? -1 : Q[tail];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear+1)%capacity == front;
    }
}