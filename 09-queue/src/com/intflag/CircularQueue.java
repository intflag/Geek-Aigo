package com.intflag;

import java.util.Arrays;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-12-24 16:11
 * @Description 基于数组的循环队列
 */
public class CircularQueue {

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
     *
     * @param size
     */
    public CircularQueue(int size) {
        this.size = size;
        items = new String[size];
    }

    /**
     * 入队操作
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        /**
         * 队列已满
         */
        if ((tail + 1) % size == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % size;
        return true;
    }

    /**
     * 出队操作
     *
     * @return
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String temp = items[head];
        head = (head + 1) % size;
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
