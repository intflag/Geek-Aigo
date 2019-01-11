package com.intflag;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-01-11 14:47
 * @Description
 */
public class SortTest {

    @Test
    public void fun1() {
        BubbleSort bubbleSort = new BubbleSort();
        String result = bubbleSort.getResult(SmartSortTool.generateData(1000));
        System.out.println(result);
    }

    @Test
    public void fun2() {
        InsertionSort insertionSort = new InsertionSort();
        String result = insertionSort.getResult(SmartSortTool.generateData(1000));
        System.out.println(result);
    }

    @Test
    public void fun3() {
        SelectionSort selectionSort = new SelectionSort();
        String result = selectionSort.getResult(SmartSortTool.generateData(1000));
        System.out.println(result);
    }

    /**
     * 三种排序进行对比测试
     */
    @Test
    public void fun4() {
        int[] arr = SmartSortTool.generateData(1000);
        System.out.println("------------------------冒泡排序------------------------");
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        System.out.println(new BubbleSort().getResult(arr1));
        System.out.println("------------------------插入排序------------------------");
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println(new InsertionSort().getResult(arr2));
        System.out.println("------------------------选择排序------------------------");
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        System.out.println(new SelectionSort().getResult(arr3));
    }
}
