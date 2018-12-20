package com.intflag;

import org.junit.Test;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-12-20 10:59
 * @Description 测试栈
 */
public class ArrayStackTest {

    @Test
    public void fun1() {
        ArrayStack stack = new ArrayStack(10);
        stack.push("haha");
        stack.push("heihei");
        stack.push("xixi");

        System.out.println(stack.getPop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.printAll();
    }
}
