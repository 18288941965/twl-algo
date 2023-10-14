package org.algo.sort;

/**
 * 插入排序.
 * 时间复杂的 O(n²)
 * 空间复杂度 O(1).
 *  插⼊排序是稳定原地排序算法。
 * ⾸先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有⼀个元素，就是数组中的第⼀个元素。
 * 插⼊算法的核⼼思想是取未排序区间中的元素，在已排序区间中找到合适的插⼊位置将其插⼊，并保证已排序区间数据⼀直有序。
 * 重复这个过程，直到未排序区间中元素为空，算法结束。
 */
public class InsertionSort {

    public static void main(String[] args) {
        insertionSorting();
    }

    public static void insertionSorting () {
        int[] arr = {1,5,6,9,1,2,7};
        for (int i = 1; i < arr.length; ++i) {
            int value = arr[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];  // 数据移动
                } else {
                    break;
                }
            }
            arr[j+1] = value; // 插入数据
        }
    }
}
