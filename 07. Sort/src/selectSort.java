import org.junit.Test;
/*
 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
第二次遍历n-2个数，找到最小的数值与第二个元素交换；
。。。
第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。

 */

import java.util.Arrays;

public class selectSort {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void selectSort1(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                // 多次交换
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }

        }
    }

    // 优化：每次只进行一次交换
    public void selectSort2(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < N; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

    @Test
    public void testSelectSort() {
        int[] arr = {4, 7, 1, 98, 43, 0, -2, 48};
        System.out.println(Arrays.toString(arr));
        selectSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
