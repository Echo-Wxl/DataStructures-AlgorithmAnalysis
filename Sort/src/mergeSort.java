import org.junit.Test;

import java.util.Arrays;

/**
 *归并排序是建立在归并操作上的一种有效的排序算法，该算法是采用分治法的一个非常典型的应用。将已有序的子
 * 序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序
 * 表，称为二路归并。
 */

public class mergeSort {
    public void mergeArray0(int[] arr, int first, int middle, int end, int[] temp) {
        int i = first;
        int m = middle;
        int j = middle+1;
        int n = end;
        int k = 0;
        while (i <= m && j <= n) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i];
            } else {
                temp[k++] = arr[j];
            }
        }

        while (i <= m) {
            temp[k++] = arr[i++];
        }
        while (j <= n) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < k; l++) {
            arr[first + l] = temp[l];
        }
    }

    public void mergeArray(int[] arr, int first, int middle, int end, int[] temp) {
        int i = first;
        int m = middle;
        int j = middle + 1;
        int n = end;
        int k = 0;
        while (i <= m && j <= n) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= m) {
            temp[k++] = arr[i++];
        }

        while (j <= n) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < k; l++) {
            arr[first + l] = temp[l];
        }
    }

    public void mergeSort(int[] arr, int first, int last, int[] temp) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(arr, first, middle, temp);
            mergeSort(arr, middle + 1, last, temp);
            mergeArray(arr, first, middle, last, temp);
        }
    }

    @Test
    public void testInsertSort() {
        int[] arr = {4, 7, 1, 98, 43, 0, -2, 48, 1};
        System.out.println(Arrays.toString(arr));
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, 8, temp);
        System.out.println(Arrays.toString(arr));
    }
}
