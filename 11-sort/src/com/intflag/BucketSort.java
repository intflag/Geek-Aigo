package com.intflag;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-01-15 16:56
 * @Description 桶排序
 */
public class BucketSort extends SmartSortTool {
    @Override
    public int[] sort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        /**
         * 桶排序适用于数据范围不大的情况下，这里假设待排序数最多值为10000
         */
        int[] buckets = new int[10001];
        for (int i = 0; i < array.length; i++) {
            buckets[array[i]] += 1;
        }
        /**
         * 拷贝
         */
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                array[index++] = i;
            }
        }
        return array;
    }
}
