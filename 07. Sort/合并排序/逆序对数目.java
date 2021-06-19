/*
一个整数数组，当 a[i] > a[j]，并且 i < j 的时候，(a[i], a[j]) 构成一个逆序对。求一个数组中逆序对的数目。

输入：[1, 2, 3, 4, 0]

输出：4

解释：数字 0 会和前面的每一个数构成逆序对。一共有 4 对。所以输出 4。

 */

class Solution {
    int cnt = 0;
    private void mergeSort(int[] arr, int first, int end, int[] temp) {
        if (first >= end || first + 1 == end) {
            return;
        }
        final int middle = first + ((end - first) >> 1);
        mergeSort(arr, first, middle, temp);
        mergeSort(arr, middle, end, temp);

        int i = first;
        int j= middle;
        int k = first;
        while (i < middle || j < end) {
            if (j >= end || i < middle && arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
                cnt += j-middle; // 在合并排序基础上加上这一句就可以了
            } else {
                temp[k++] = arr[j++];
            }
        }
        for (int l = first; l < end; l++) {
            arr[l] = temp[l];
        }
    }

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] temp = new int[nums.length];
        cnt = 0;
        mergeArray0(nums, 0, nums.length, temp);
    }
}