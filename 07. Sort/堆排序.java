class solution {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void heapSink(int[] arr, int i, int len) {
        int left = 2*i+1;
        int right = 2*i + 2;

        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapSink(arr, largest, len);
        }
    }

    private void makeMaxHeap(int[] arr, int len) {
        for (int i = len/2; i>=0; i--) {
            heapSink(arr, i, len);
        }
    }

    public void heapSort(int[] arr) {
        int N = arr.length;
        makeMaxHeap(arr, N);
        for (int i = N -1; i>0;i--) {
            swap(arr, 0, i);
            N--;
            heapSink(arr, 0, N);
        }
    }
}