class solution {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void shellSort(int[] arr) {
        int N=arr.length;
        int incre = N/2;

        while (true) {
            incre = incre/2;
            for (int i = 0; i < incre; i++) {

                for (int j = i+incre; j < N; j+=incre) {

                    for (int k = j; k > i; k-=incre) {
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
}