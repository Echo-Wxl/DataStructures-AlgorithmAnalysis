/*
大顶堆，根比左右节点都大
 */
public class Heap {
    private int[] heap = null;
    private int n = 0;

    public Heap(int k) {
        heap = new int[k];
    }

    /*
    下沉操作
     */
    public void sink(int i) {
        int j = 0;
        int curVal = heap[i];
        while ((j = (i << 1) + 1) < n) {
            if (j < n - 1 && heap[j] < heap[j + 1]) {
                j++;
            }
            if (heap[j] > curVal) {
                heap[i] = heap[j];
                i = j;
            } else {
                break;
            }
        }
        heap[i] = curVal;
    }

    /*
    上浮
     */
    public void swim(int i) {
        int curVal = heap[i];
        int par = 0;

        while (i > 0 && (par = (i - 1) >> 1) != i) {
            if (heap[par] < curVal) {
                heap[i] = heap[par];
                i = par;
            } else {
                break;
            }
        }
        heap[i] = curVal;
    }

    /*
    入堆：
    1. 先把元素加在最后
    2. 进行上浮操作
     */
    public void push(int val) {
        heap[n++] = val;
        swim(n - 1);
    }

    /*
    出堆：
    1. 去除heap[0]的值作为返回值
    2. 将heap[n-1]的存放在heap[0]
    3. 将heap[0]进行下沉操作
     */
    public int pop() {
        int ret = heap[0];
        heap[0] = heap[--n];
        sink(0);
        return ret;
    }

    public int size() {
        return n;
    }
}