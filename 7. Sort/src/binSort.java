import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 */

public class binSort {
    public void binSort(int[] arr) {
        // 找到最大最小值
        int max = arr[0];
        int min = arr[0];
        int N = arr.length;
        
        for (int i = 1; i < N; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        int diff = max -min;
        
        // 创建桶
        ArrayList<ArrayList<Integer>> bin = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            bin.add(new ArrayList<>());
        }

        //每个桶的存数区间
        float section = (float) diff / (float) (N - 1);

        //数据入桶
        for(int i = 0; i < N; i++){
            //当前数除以区间得出存放桶的位置 减1后得出桶的下标
            int num = (int) (arr[i] / section) - 1;
            if(num < 0){
                num = 0;
            }
            bin.get(num).add(arr[i]);
        }

        //桶内排序
        for(int i = 0; i < bin.size(); i++){
            //jdk的排序速度当然信得过
            Collections.sort(bin.get(i));
        }

        //写入原数组
        int index = 0;
        for(ArrayList<Integer> arrayList : bin){
            for(int value : arrayList){
                arr[index] = value;
                index++;
            }
        }
    }

    @Test
    public void testInsertSort() {
        int[] arr = {4, 7, 1, 98, 43, 0, 48, 1, -2};
        System.out.println(Arrays.toString(arr));
        binSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
