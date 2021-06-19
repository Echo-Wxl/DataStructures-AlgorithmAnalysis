class solution{

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void kthNumber(int[] arr, int n, int k) {
        return threeSplit(arr, 0, n, k-1);
    }

    private int threeSplit(int[] arr, int first, int end, int k) {
        if (first >= end) {
            return 0;
        }
        int middle = first + ((end - first) >> 1);
        int pivot = arr[middle];

        int l=0, i=0, r = end-1;

        while (i <= r) {
            if (arr[i] < pivot) {
                swap(arr, i++, l++);
            } else if (arr[i] == pivot) {
                i++;
            } else {
                swap(arr, i, r--);
            }
        }
        int lcnt = l-first;
        int mcnt = i-l;
        if (lcnt > k) {
            return threeSplit(arr, first, l, k);
        }
        if (k >= mcnt + lcnt) {
            return threeSplit(arr, i, end, k);
        }
        return pivot;
    }
}