package com.intflag;

import java.util.Random;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-01-11 14:34
 * @Description 测试工具类
 */
abstract class SmartSortTool {

    /**
     * 生成测试数据
     *
     * @param n
     * @return
     */
    public static int[] generateData(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    public final String getResult(int[] array) {
        long start = System.currentTimeMillis();
        int[] sort = sort(array);
        long end = System.currentTimeMillis();
        String time = (end - start) + " ms";
        String res = "\n";
        for (int i = 0; i < sort.length; i++) {
            res += sort[i] + " ";
        }
        return time + res;
    }

    public abstract int[] sort(int[] array);
}
