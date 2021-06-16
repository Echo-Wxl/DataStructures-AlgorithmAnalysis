public class solution {
    public void mergeArray(int[] arr, int first, int end, int[] temp) {
        if (first >= end || first + 1 == end) {
            return;
        }

        int middle = first + ((end - first) >> 1);
        mergeArray0(arr, first, middle, temp);
        mergeArray0(arr, middle, end, temp);

        int i = 0;
        int j = middle;
        int k = 0;
        while (i < middle || j < end) {
            if (j >= end || i < middle && arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        for (int l = 0; l < end; l++) {
            arr[l] = temp[l];
        }
    }

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] temp = new int[nums.length];
        mergeArray(nums, 0, nums.length, temp);
    }

    @Test
    public void testSort() {
        int[] arr = {4, 7, 1, 98, 43, 0, -2, 48, 1};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, 9);
        System.out.println(Arrays.toString(arr));
    }
}