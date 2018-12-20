package com.intflag;

import org.junit.Test;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-12-20 11:31
 * @Description
 */
public class BrowserStackTest {

    @Test
    public void fun1() {
        BrowserStack browserStack = new BrowserStack();
        browserStack.request("www.baidu.com");
        browserStack.request("www.google.com");
        browserStack.request("www.taobao.com");
        browserStack.request("www.jd.com");

        System.out.println(browserStack.prev());
        System.out.println(browserStack.prev());
        System.out.println(browserStack.prev());
        System.out.println(browserStack.prev());
        System.out.println("------------------------");
        System.out.println(browserStack.next());
        System.out.println(browserStack.next());
        System.out.println(browserStack.next());
        System.out.println(browserStack.next());
    }
}
