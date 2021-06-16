import org.junit.Test;

import java.util.Arrays;

/**
 * 在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序。
 * 然后逐渐将增量减小,并重复上述过程。直至增量为1,此时数据序列基本有序,最后进行插入排序。
 *
 */

public class shellSort {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void shellSort(int[] arr) {
        int N = arr.length;
        int incre = N;
        while (true) {
            incre = incre / 2;
            for (int i = 0; i < incre; i++) {

                for (int j = i + incre; j < N; j += incre) {

                    for (int k = j; k > i; k -= incre) {
                        if (arr[k] < arr[k - incre]) {
                            swap(arr, k, k - incre);
                        } else {
                            break;
                        }
                    }
                }
            }
            if (incre == 1) {
                break;
            }
        }
    }

    @Test
    public void testInsertSort() {
        int[] arr = {4, 7, 1, 98, 43, 0, -2, 48, 1};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
