package com.intflag;

import java.util.Arrays;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-12-24 16:11
 * @Description 基于数据的顺序队列
 */
public class ArrayQueue {

    /**
     * 数组，用来存储数据
     */
    private String items[];
    /**
     * 数组大小
     */
    private int size;
    /**
     * 对头指针
     */
    private int head;
    /**
     * 队尾指针
     */
    private int tail;

    /**
     * 初始化队列，申请一个大小为size的数组
     * @param size
     */
    public ArrayQueue(int size) {
        this.size = size;
        items = new String[size];
    }

    /**
     * 入队操作
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        /**
         * 队尾已经到数组末尾，没有空间了
         */
        if (size == tail) {
            /**
             * 队列已满，不能入队
             */
            if (head == 0) {
                return false;
            }
            /**
             * 数据搬移
             */
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            /**
             * 搬移后更新队头指针和队尾指针
             */
            tail -= head;
            head = 0;

        }
        items[tail++] = item;
        return true;
    }

    /**
     * 出队操作
     * @return
     */
    public String dequeue(){
        if (head == tail) {
            return null;
        }
        String temp = items[head++];
        return temp;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
