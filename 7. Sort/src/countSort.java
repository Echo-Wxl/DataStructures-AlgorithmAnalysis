import org.junit.Test;

import java.util.Arrays;

public class countSort {
    public void countSort(int[] arr) {
        // 找到数组最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 初始化计数数组
        int[] countArr = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
            arr[i] = 0;
        }

        // 排序
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                arr[index++] = i;
                countArr[i]--;
            }
        }
    }

    @Test
    public void testInsertSort() {
        int[] arr = {4, 7, 1, 98, 43, 0, 48, 1};
        System.out.println(Arrays.toString(arr));
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
