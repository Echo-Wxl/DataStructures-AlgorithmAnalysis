/*
给定一个长度为 n 的整数数列，以及一个整数 k，请用快速选择算法求出数列从小到大排序后的第 k 个数。

输入格式
第一行包含两个整数 n 和 k。

第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整数数列。

输出格式
输出一个整数，表示数列的第 k 小数。

数据范围
1≤n≤100000,
1≤k≤n
输入样例：
5 3
2 4 1 5 3
输出样例：
3
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.parseInt(sc.next());
            int k = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0;i<n;i++){
                nums[i] = Integer.parseInt(sc.next());
            }
            // 方法一：使用大顶推
            // int res = maxHeap(nums, k);

            // 方法二：快排O(n)
            int res = getKnumber(nums, k);
            System.out.println(res);
        }
    }

    private static int maxHeap(int[] nums, int k){
        int N = nums.length;

        Queue<Integer> pq = new PriorityQueue<>((o1, o2)->o2-o1);

        for(int i = 0;i<N;i++){
            pq.offer(nums[i]);
            while(!pq.isEmpty() && pq.size() >k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    private  static int getKnumber(int[] nums, int k){
        return quickSort(nums, 0, nums.length, k-1);
    }

    private static int quickSort(int[] nums, int start, int end, int k){
        if(start >= end || start+1==end){
            return 0;
        }
        if(start+1 == end){
            return nums[start];
        }

        int mid = start+((end-start)>>1);
        int pivot = nums[mid];

        int l =start, i = start, r = end-1;
        while(i<=r){
            if(nums[i]<pivot){
                swap(nums, i++, l++);
            }else if(nums[i]==pivot){
                i++;
            }else{
                swap(nums, i, r--);
            }
        }

        int lcnt = l-start;
        int mcnt = i-l;
        if(lcnt>k){
            return quickSort(nums, start, l, k);
        }
        if(k>= lcnt+mcnt){
            return quickSort(nums, i, end, k-lcnt-mcnt);
        }
        return pivot;
    }


    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}