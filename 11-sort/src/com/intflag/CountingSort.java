package com.intflag;

import org.junit.Test;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-01-15 17:59
 * @Description 计数排序
 */
public class CountingSort extends SmartSortTool {
    @Override
    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        /**
         * 先进行桶排序,假设数据范围在10000以内
         */
        int[] buckets = new int[10001];
        for (int i = 0; i < array.length; i++) {
            buckets[array[i]] += 1;
        }
        /**
         * 然后桶里存储小于等于 k 的个数。
         */
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] += buckets[i - 1];
        }
        /**
         * 扫描
         */
        int[] res = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int index = buckets[array[i]] - 1;
            res[index] = array[i];
            buckets[array[i]] -= 1;
        }
        return res;
    }

}
