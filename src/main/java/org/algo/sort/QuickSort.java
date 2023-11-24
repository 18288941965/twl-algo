package org.algo.sort;

import java.util.Arrays;

/**
 * 快速排序.
 * 时间复杂的 O(nlogn).
 * 空间复杂度 O(1).
 * 快速排序是⾮稳定原地排序算法。空间复杂度是O(logn)。
 * 如果要排序数组中下标从p到r之间的⼀组数据，我们选择p到r之间的任意⼀个数据作为pivot（分区点），
 * 然后，遍历p到r之间的数据，将⼩于pivot的放到左边，将⼤于pivot的放到右边，将pivot放到中间。
 * 经过这⼀步骤之后，p到r之间的数据就被分成了三个部分。假设pivot现在所在位置的下标是q，
 * 那p到q-1之间数据都⼩于pivot，中间是pivot，q+1到r之间的数据都⼤于pivot。
 * 根据分治、递归的处理思想，我们递归排序下标从p到 q-1之间的数据和下标从q+1到r之间的数据，
 * 直到区间缩⼩为1，就说明所有的数据都有序了。
 * 递推公式：
 * quickSort(p…r)=quickSort(p…q-1) & quickSort(q+1…r)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1,5,6,9,1,2,7};
        quickSortInternally(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        int q = partition(a, p, r); // 获取分区点并且移动数据
        quickSortInternally(a, p, q-1);
        quickSortInternally(a, q+1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            // 把小于pivot 的移动到左侧
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        // 把pivot移动到中间
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        System.out.println("i=" + i);
        return i;
    }
}
