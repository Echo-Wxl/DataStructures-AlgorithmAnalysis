class solution {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void selectSort(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < N; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }

}