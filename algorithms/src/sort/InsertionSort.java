package sort;

import java.util.*;

public class InsertionSort {

    private InsertionSort() {}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for(int i = 0; i < n; i ++) {

//            // 写法1
//            for(int j = i; j > 0; j -- )
//                if (arr[j].compareTo(arr[j-1]) < 0)
//                    swap(arr, j, j-1);
//                else
//                    break;
//
//            // 写法2：插入排序是可以提前结束内层循环的
//            for(int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--)
//                swap(arr, j, j-1);

            // 写法3
            Comparable e = arr[i];
            // j保存元素e应该插入的位置
            int j = i;
            for( ; j > 0 && arr[j].compareTo(arr[j-1]) > 0; j--)
                arr[j] = arr[j-1];
            arr[j] = e;


        }
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr, int l, int r){
        for(int i = l + 1; i <= r; i ++) {
            Comparable e = arr[i];
            int j = i;
            for( ; j > l && arr[j - 1].compareTo(e) > 0 ; j --)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 10000;
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(n, 100);

        SortTestHelper.testSort("sort.InsertionSort", arr);
        SortTestHelper.testSort("sort.SelectionSort", arr);
    }
}
