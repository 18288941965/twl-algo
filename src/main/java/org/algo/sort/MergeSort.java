package org.algo.sort;

import org.algo.loaddata.bean.Bean01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 归并排序算法.
 * 时间复杂的 O(nlogn).
 * 归并排序是稳定⾮原地排序算法。空间复杂度是O(n)。
 * 如果要排序⼀个数组，我们先把数组从中间分成前后两部分，然
 * 后，对前后两部分分别排序，再将排好序的两部分合并在⼀起，
 * 这样整个数组就都有序了。
 * 递推公式：
 * mergeSort(p…r)=merge(mergeSort(p…q), mergeSort(q+1…r))
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1,5,6,9,1,2,7};
        mergeSortInternally(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        // 100000条数据执行时间:  162  || 148 || 182 毫秒
       /* List<Bean01> list = LoadCsvFile.loadDataByCsv(100000);
        long start = System.currentTimeMillis();
        mergeSortInternally2(list, 0 , list.size() -1);
        System.out.printf("执行时间: %d", System.currentTimeMillis() - start);*/

        /*for (int i = 99900; i < 100000; i++) {
            System.out.println(list.get(i).toString());
        }*/
       /* list.forEach(item -> {
            System.out.println(item.toString());
        });*/
    }


    // 递归调用函数
    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if (p >= r) return;

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p)/2;
        // 分治递归
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q+1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        System.out.println("p==" + p + "==q==" + q + "==r==" + r);
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0; // 初始化变量i, j, k
        int[] tmp = new int[r-p+1]; // 申请一个大小跟a[p...r]一样的临时数组
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++]; // i++等于i:=i+1
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = tmp[i];
        }
    }

    private static void mergeSortInternally2(List<Bean01> list, int p, int r) {
        // 递归终止条件
        if (p >= r) return;

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p + (r - p)/2;
        // 分治递归
        mergeSortInternally2(list, p, q);
        mergeSortInternally2(list, q+1, r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge2(list, p, q, r);
    }

    private static void merge2(List<Bean01> list, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0; // 初始化变量i, j, k
        List<Bean01> tmp = new ArrayList<>(r-p+1); // 申请一个大小跟a[p...r]一样的临时数组
        while (i<=q && j<=r) {
            if (list.get(i).getAmount() <= list.get(j).getAmount()) {
                 // i++等于i:=i+1
                tmp.add(k++, list.get(i++));
            } else {
                tmp.add(k++, list.get(j++));
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp.add(k++, list.get(start++));
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            list.set(p+i, tmp.get(i));
        }
    }

}
