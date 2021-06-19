class solution {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    public void quickSort(int[] arr, int first, int end) {
        if (first >= end || first + 1 == end) {
            return;
        }
        int middle = first + ((end - first) >> 1);
        int pivot = arr[pivot];

        int l = 0, i = 0, r =end-1;
        while (i <= r) {
            if (arr[i] < pivot) {
                swap(arr, l++, i++);
            } else if (arr[i] == pivot) {
                i++;
            } else {
                swap(arr, i, r--);
            }
        }

        quickSort(arr, first, middle);
        quickSort(arr, middle, end);
    }

    @Test
    public void testSort() {
        int[] arr = {4, 7, 1, 98, 43, 0, -2, 48, 1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, 9);
        System.out.println(Arrays.toString(arr));
    }
}