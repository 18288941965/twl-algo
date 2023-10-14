package org.algo.sort;

/**
 * 选择排序 .
 *  时间复杂的 O(n²).
 *  空间复杂度 O(1).
 *  选择排序算法是⾮稳定原地排序算法。
 * 其实现思路有点类似插⼊排序，也分已排序区间和未排序区间。
 * 但不同点在于，选择排序算法每次会从未排序区间中，找到最⼩的元素，将其放到已排序区间的末尾.
 * [代码提示：每次查找最小的数索引，然后进行交换]
 */
public class SelectionSort {

    public static void main(String[] args) {
        selectionSort();
    }

    public static void selectionSort () {
        int[] arr = {1,5,6,9,1,2,7};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 顺排
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
                // 倒排
                // minIndex = arr[j] > arr[minIndex] ? j : minIndex;
            }
            // 交换位置
            int tem = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tem;
        }
        // 输出结果
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "-");
        }
    }

}
