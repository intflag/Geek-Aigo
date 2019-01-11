package com.intflag;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-01-11 15:25
 * @Description 选择排序
 */
public class SelectionSort extends SmartSortTool {
    /**
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            /**
             * 找到最小的数，将最小的数的索引保存
             */
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
