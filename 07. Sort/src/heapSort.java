import org.junit.Test;

import java.util.Arrays;

/**
 *创建一个堆 H[0……n-1]；
 * 把堆首（最大值）和堆尾互换；
 * 把堆的尺寸缩小 1，并把新的数组顶端数据调整到相应位置；
 * 重复步骤 2，直到堆的尺寸为 1。
 */

public class heapSort {

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void makeMinHeap(int[] arr, int n) {
        for (int i = (n-1)/2; i >= 0; i--) {
            minHeapFixDown(arr, i, n);
        }
    }

    public void minHeapFixDown(int[] arr, int i, int n) {
        int j = 2*i+1;

        while (j < n) {
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j++;
            }

            if (arr[i] > arr[j]) {
                break;
            }
            swap(arr, i, j);

            i = j;
            j = 2*i+1;
        }
    }

    public void heapSort(int[] arr, int n) {
        makeMinHeap(arr, n);

        for (int i = n-1; i > 0; i--) {
            swap(arr, i, 0);
            minHeapFixDown(arr, 0, i);
        }
    }

    @Test
    public void testInsertSort() {
        int[] arr = {4, 7, 1, 98, 43, 0, -2, 48, 1};
        System.out.println(Arrays.toString(arr));
        heapSort(arr, 9);
        System.out.println(Arrays.toString(arr));
    }

}
