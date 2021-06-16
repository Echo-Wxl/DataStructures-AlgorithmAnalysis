class solution {
    public void bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0) {
            return;
        }

        int N = arr.length;
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            } else if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i]-minValue)/bucketSize);
            buckets[index] = arrappend(buckets[index], arr[i]);
        }

        int index = 0;
        for (int[] bucket : buckets) {
            Arrays.sort(bucket);
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }


    private int[] arrappend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length+1);
        arr[arr.length-1] = value;
        return arr;
    }
}