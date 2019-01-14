package com.intflag;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-01-14 18:28
 * @Description
 */
public class QuickSort extends SmartSortTool {
    @Override
    public int[] sort(int[] array) {
        quickSortInternally(array, 0, array.length - 1);
        return array;
    }

    /**
     * 快速排序递归函数，p,r为下标
     *
     * @param a
     * @param p
     * @param r
     */
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }

        /**
         * 获取分区点
         */
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
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

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
