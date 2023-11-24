package org.algo.sort;

import org.algo.loaddata.bean.Bean01;

import java.util.Arrays;
import java.util.List;

/**
 * 冒泡排序.
 * 时间复杂的 O(n²)
 * 空间复杂度 O(1)
 * 冒泡排序是稳定原地排序算法。
 * 整个冒泡排序过程包含多遍冒泡操作。每次冒泡操作都会遍历整个数组，依次对相邻的元素进⾏⽐较，看是否满⾜⼤⼩关系要求，如果不满⾜，就将它们互换位置。
 * ⼀次冒泡操作会让⾄少⼀个元素移动到它应该在的位置，重复n次，就完成了n个数据的排序⼯作。
 * [代码提示：第一个for为要走几趟才能完成排序，第二个for为本次排序需要遍历多少次]
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,5,6,9,1,2,7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        // 100000条数据执行时间: 69555 || 68078 || 65446毫秒
        List<Bean01> list = LoadCsvFile.loadDataByCsv(100000);
        long start = System.currentTimeMillis();
        bubbleSort3(list);
        System.out.printf("执行时间: %d", System.currentTimeMillis() - start);

        /*
        list.forEach(item -> {
            System.out.println(item.toString());
        });*/
    }

    public static void bubbleSort (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void bubbleSort2(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j+1];
                    arr[j+1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j] ^ arr[j+1];
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void bubbleSort3(List<Bean01> list) {
        for (int i = 1; i < list.size(); i++) {
            boolean flag = false;
            for (int j = 0; j < list.size() - i; j++) {
                if (list.get(j).getAmount() > list.get(j + 1).getAmount()) {
                    Bean01 bean01 = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, bean01);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}
