package com.intflag;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-01-10 10:59
 * @Description 经典台阶算法
 */
public class StairsTest {

    private static Map<Long, Long> map = new HashMap<>();

    public static long f(long n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        /**
         * 先从散列表中拿结果，如果没有则进行计算，有直接返回
         */
        if (map.containsKey(n)) {
            return map.get(n);
        }

        long res = f(n - 1) + f(n - 2);
        /**
         * 将计算过的步骤加入散列表，避免重复计算
         */
        map.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(StairsTest.f(50));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
