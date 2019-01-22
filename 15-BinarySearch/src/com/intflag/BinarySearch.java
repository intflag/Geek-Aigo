package com.intflag;

import org.junit.Test;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-01-22 16:16
 * @Description 二分查找
 */
public class BinarySearch {

    private static int n = 10000001;

    private static int[] arr = new int[n];

    static {
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    /**
     * 普通二分查找
     *
     * @param arr
     * @param value
     * @return
     */
    public int bSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int count = 0;
        while (low <= high) {
            count++;
            int mid = (low + high) / 2;
            if (arr[mid] == value) {
                System.out.println("循环次数：" + count);
                return mid;
            } else if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("循环次数：" + count);
        return -1;
    }

    /**
     * 递归二分查找
     *
     * @param arr
     * @param low
     * @param high
     * @param value
     * @return
     */
    public int bSearch(int[] arr, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return bSearch(arr, mid + 1, high, value);
        } else {
            return bSearch(arr, low, mid - 1, value);
        }
    }

    /**
     * 变体一：查找第一个值等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public int firstEqualSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 变体二：查找最后一个值等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public int lastEqualSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < value) {
                low = mid + 1;
            } else if (arr[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == arr.length - 1 || arr[mid + 1] != value) {
                    return mid;
                } else {
                    high = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 变体三：查找第一个大于等于给定值的元素
     *
     * @param arr
     * @param value
     * @return
     */
    public int firstGtAndEqSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                if (mid == 0 || arr[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 变体四：查找最后一个小于等于给定值的元素
     * @param arr
     * @param value
     * @return
     */
    public int lastLtAndEqSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] <= value) {
                if (mid == arr.length - 1 || arr[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void fun1() {
        long start = System.currentTimeMillis();
//        int index = bSearch(BinarySearch.arr, -1);
        int index = bSearch(BinarySearch.arr, 0, BinarySearch.arr.length - 1, 1000);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("被查找的数值下标：" + index + "，用时：" + time + "ms");

    }

    @Test
    public void fun2() {
        int[] arr = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 12, 13};
        System.out.println(lastEqualSearch(arr, 8));
        System.out.println(bSearch(arr, 8));
    }

    @Test
    public void fun3() {
        int[] arr = new int[]{3, 4, 6, 7, 7, 7, 10};
        System.out.println(firstGtAndEqSearch(arr, 5));
        System.out.println(lastLtAndEqSearch(arr,7));
    }
}
