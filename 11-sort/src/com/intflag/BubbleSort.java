package com.intflag;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-01-11 14:04
 * @Description 冒泡排序
 */
public class BubbleSort extends SmartSortTool {

    @Override
    public int[] sort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }
        return array;
    }

}
