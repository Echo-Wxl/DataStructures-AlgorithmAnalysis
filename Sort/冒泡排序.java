class solution {
    public viod bubbleSort(int[] arr) {
        int N = arr.length;
        boolean flag = true;
        for (int i = 0; i < N-1 && flag; i++) {
            flag = false;
            for (int j = 0; j < N-i-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                    flag = true;
                }
            }
        }
    }

    private  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}