package com.intflag;

import org.junit.Test;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-12-24 16:22
 * @Description 测试
 */
public class QueueTest {

    @Test
    public void fun1() {
        ArrayQueue queue = new ArrayQueue(5);
        System.out.println(queue.enqueue("11"));
        System.out.println(queue.enqueue("22"));
        System.out.println(queue.enqueue("33"));
        System.out.println(queue.enqueue("44"));
        System.out.println(queue.enqueue("55"));
        System.out.println(queue.toString());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue("66"));
        System.out.println(queue.toString());
    }

    @Test
    public void fun2() {
        CircularQueue queue = new CircularQueue(5);
        System.out.println(queue.enqueue("11"));
        System.out.println(queue.enqueue("22"));
        System.out.println(queue.enqueue("33"));
        System.out.println(queue.enqueue("44"));
        System.out.println(queue.enqueue("55"));
        System.out.println(queue.toString());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue("66"));
        System.out.println(queue.toString());
    }
}
