/*
只使用 k 个元素的空间，三个变量 front, rear, used 来控制循环队列的使用
 */
class MyCircularQueue{
    private int[] Q = null;
    private int capacity;
    private int front = 0;
    private int rear = 0;
    private int used = 0;

    public MyCircularQueue(){}

    public MyCircularQueue(int k) {
        capacity = k;
        Q = new int[capacity];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        Q[rear] = value;
        rear = (rear+1)%capacity;
        used++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front+1)%capacity;
        used--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return Q[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return Q[rear];
    }

    public boolean isEmpty() {
        return used =0;
    }

    public boolean isFull() {
        return used = capacity;
    }
}