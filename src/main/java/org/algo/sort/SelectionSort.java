package org.algo.sort;

import org.algo.loaddata.bean.Bean01;

import java.util.Arrays;
import java.util.List;

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
        int[] arr = {1,5,6,9,1,2,7};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        // 100000条数据执行时间: 116377 || 149713 毫秒
        List<Bean01> list = LoadCsvFile.loadDataByCsv(100000);
        long start = System.currentTimeMillis();
        selectionSort2(list);
        System.out.printf("执行时间: %d", System.currentTimeMillis() - start);

        /*
        list.forEach(item -> {
            System.out.println(item.toString());
        });*/
    }

    public static void selectionSort (int[] arr) {
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
    }

    public static void selectionSort2(List<Bean01> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                minIndex = list.get(j).getAmount() < list.get(minIndex).getAmount() ? j : minIndex;
            }
            Bean01 bean01 = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, bean01);
        }
    }
}
