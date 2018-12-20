package com.intflag;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-12-20 11:10
 * @Description 简单模拟浏览器前进后退
 */
public class BrowserStack {

    private String currUrl;

    /**
     * 前进栈
     */
    private ArrayStack nextStack;
    /**
     * 后退栈
     */
    private ArrayStack prevStack;

    /**
     * 初始化浏览器历史记录栈
     */
    public BrowserStack() {
        this.nextStack = new ArrayStack(1024);
        this.prevStack = new ArrayStack(1024);
    }

    /**
     * 请求新网址
     *
     * @param url
     */
    public void request(String url) {
        nextStack.push(currUrl);
        currUrl = url;
    }

    /**
     * 浏览器后退
     * @return
     */
    public String prev() {
        /**
         * 从前进栈取出栈顶元素
         */
        String temp = nextStack.pop();
        /**
         * 空则代表无法后退
         */
        if (temp == null) {
            return temp;
        }
        /**
         * 入后退栈
         */
        prevStack.push(currUrl);
        currUrl = temp;
        return currUrl;
    }

    /**
     * 浏览器前进
     * @return
     */
    public String next() {
        /**
         * 从后退栈取出栈顶元素
         */
        String temp = prevStack.pop();
        /**
         * 空则代表无法前进
         */
        if (temp == null) {
            return temp;
        }
        /**
         * 入前进栈
         */
        nextStack.push(currUrl);
        currUrl = temp;
        return currUrl;
    }
}
