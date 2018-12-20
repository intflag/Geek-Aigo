package com.intflag;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-12-20 10:28
 * @Description 基于数组的顺序栈
 */
public class ArrayStack {

    /**
     * 数组
     */
    private String[] items;
    /**
     * 栈中元素个数
     */
    private int count;
    /**
     * 栈的大小
     */
    private int size;

    /**
     * 初始化数组，申请一个大小为size的数组空间
     * @param size
     */
    public ArrayStack(Integer size) {
        this.size = size;
        this.items = new String[size];
        this.count = 0;
    }

    /**
     * 入栈操作
     * @param item
     * @return
     */
    public boolean push(String item) {
        /**
         * 如果数组空间不够了，则返回入栈失败
         */
        if (size == count) {
            return false;
        }
        /**
         * 给数组赋值，栈大小自增1
         */
        items[count++] = item;
        return true;
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public String getPop() {
        if (count == 0) {
            return null;
        }
        return items[count-1];
    }

    public String pop() {
        /**
         * 如果元素个数为0，则返回空
         */
        if (count == 0) {
            return null;
        }
        /**
         * 返回栈顶元素
         */
        String temp = items[count-1];
        count--;
        return temp;
    }

    /**
     * 打印全部
     */
    public void printAll() {
        for (int i = 0; i < count; i++ ) {
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }

    public int getCount() {
        return count;
    }
}
