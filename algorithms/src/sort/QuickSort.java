package sort;

import java.util.*;

public class QuickSort {

    private QuickSort() {
    }

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用，对arr[l...r]部分进行快速排序
    private static void sort(Comparable[] arr, int l, int r) {

        // merge sort 无优化版本
//        if (l >= r)
//            return;

        // 优化1: 对于小规模数组, 使用插入排序
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p，使得arr[l...p-1] < arr[p]；arr[p+1. r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {

        // 优化2：随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, r, (int)(Math.random()*(r-l+1))+l);

        Comparable v = arr[r];

        int i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j].compareTo(v) < 0) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static public void main(String[] args) {
//        Comparable[] a = {4, 3, 4, 5, 6, 2, 1, 7};
//        QuickSort.sort(a);
//        for( int i = 0 ; i < a.length ; i ++ ){
//            System.out.print(a[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
//        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 100);
        SortTestHelper.testSort("sort.QuickSort", arr);
        SortTestHelper.testSort("sort.MergeSort", arr);
    }
}
