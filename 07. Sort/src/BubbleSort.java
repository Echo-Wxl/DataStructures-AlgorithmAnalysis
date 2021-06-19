import org.junit.Test;

/*
比较相邻的两个数据，如果第二个数小，就交换位置。
从后向前两两比较，一直到比较最前两个数据。最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
继续重复上述过程，依次将第2.3...n-1个最小数排好位置。

*/
import java.util.Arrays;

public class BubbleSort {
    private  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void bubbleSort1(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public void bubbleSort2(int[] arr) {
        int N = arr.length;
        // 优化：设置已经排好序的标志
        boolean flag = true;
        for (int i = 0; i < N-1 && flag; i++) {
            flag = false;
            for (int j = 0; j < N-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                    flag = true;
                }
            }
        }
    }


    @Test
    public void test() {
        int[] arr = {4, 7, 1, 98, 43, 0, -2, 48};
        bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
