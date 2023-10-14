package org.algo.sort;

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
    public static void bubbleSort () {
        int[] arr = {1,5,6,9,1,2,7};
        // 写法一
        /*
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
        */
        // 写法二
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

    public static void main(String[] args) {
        bubbleSort();
    }
}
