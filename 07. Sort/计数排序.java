class solution {
    public void countSort(int[] arr) {
        int N = arr.length;
        int maxValue = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        int[] bucket = new int[maxValue + 1];
        for (int value : arr) {
            bucket[value]++;
        }

        int index = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j] > 0) {
                arr[index++] = j;
                bucket[j]--;
            }
        }
    }
}
