import org.junit.Test;

import java.util.Arrays;

/**
 * 先从数列中取出一个数作为key值；
 * 将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
 * 对左右两个小数列重复第二步，直至各区间只有1个数。
 */

public class quickSort {
    public void quickSort(int[] arr, int l, int r) {
        // 如果l>=r，退出
        if (l >= r) {
            return;
        }

        int i = l;
        int j = r;
        int pivot = arr[l];
        // 从右向左找到第一个小于pivot的值
        // 从左到右找到第一个大鱼pivot的值
        // 交换两者位置
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }

            while (i < j && arr[i] < pivot) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        // 将pivot赋值给当前位置
        arr[i] = pivot;
        // 递归
        quickSort(arr, l, i-1);
        quickSort(arr, i+1, r);

    }

    @Test
    public void testInsertSort() {
        int[] arr = {4, 7, 1, 98, 43, 0, -2, 48, 1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, 8);
        System.out.println(Arrays.toString(arr));
    }
}
