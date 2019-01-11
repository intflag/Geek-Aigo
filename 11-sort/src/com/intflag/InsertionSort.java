package com.intflag;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-01-11 14:54
 * @Description
 */
public class InsertionSort extends SmartSortTool {
    @Override
    public int[] sort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
