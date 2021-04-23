import org.junit.Test;

import java.util.Arrays;

/**
 * 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 * 如果数据基本有序，使用插入排序更高效
 */

public class insertSort {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void insertSort(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j-1);
                }else{
                    break;
                }
            }
        }
    }

    @Test
    public void testInsertSort() {
        int[] arr = {4, 7, 1, 98, 43, 0, -2, 48, 1};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
