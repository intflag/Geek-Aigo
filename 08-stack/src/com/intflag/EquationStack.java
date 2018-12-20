package com.intflag;

import java.util.HashMap;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-12-20 15:30
 * @Description 使用栈实现简单算式计算
 */
public class EquationStack {

    private HashMap<String, Integer> level = new HashMap<>();

    public EquationStack() {
        this.level.put("+", 1);
        this.level.put("-", 1);
        this.level.put("*", 2);
        this.level.put("/", 2);
    }

    public String calculate(String str) {

        /**
         * 用来保存数字
         */
        ArrayStack numberStack = new ArrayStack(1024);
        /**
         * 用来保存符号
         */
        ArrayStack symbolStack = new ArrayStack(1024);

        while (str.length() > 0) {
            int startIndex = 0;
            int endIndex = 0;
            for (int i = 0; i < str.length(); i++) {
                char x = str.charAt(i);
                if (x != '+' && x != '-' && x != '*' && x != '/' && i == str.length()-1) {
                    numberStack.push(str);
                    str = "";
                }
                if (x == '+' || x == '-' || x == '*' || x == '/') {
                    endIndex = i;
                    numberStack.push(str.substring(startIndex, endIndex));
                    str = str.substring(endIndex+1);

                    String pop = symbolStack.getPop();

                    if (isHigh(x+"",pop)) {
                        symbolStack.push(x + "");
                    } else {
                        while (symbolStack.getCount()!=0) {
                            String a = numberStack.pop();
                            String b = numberStack.pop();
                            String xx = symbolStack.pop();
                            numberStack.push(count(b,a,xx.charAt(0))+"");
                        }
                        symbolStack.push(x+"");
                    }
                    break;
                }
            }

        }
        while (symbolStack.getCount()!=0) {
            String a = numberStack.pop();
            String b = numberStack.pop();
            String xx = symbolStack.pop();
            numberStack.push(count(b,a,xx.charAt(0))+"");
        }
        return numberStack.pop();
    }

    /**
     * x 的级别是否大于 y
     * @param x
     * @param y
     * @return
     */
    public boolean isHigh(String x, String y) {
        if (y == null) {
            return true;
        }
        Integer a = level.get(x);
        Integer b = level.get(y);
        if (a > b) {
            return true;
        }
        return false;
    }

    /**
     * 根据符号计算两个数的值
     * @param a
     * @param b
     * @param x
     * @return
     */
    public int count(String a,String b,char x) {
        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        if (x == '+') {
            return aa+bb;
        }
        if (x == '-') {
            return aa-bb;
        }
        if (x == '*') {
            return aa*bb;
        }
        if (x == '/') {
            return aa/bb;
        }
        return 0;
    }
}
