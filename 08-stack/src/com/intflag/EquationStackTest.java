package com.intflag;

import org.junit.Test;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2018-12-20 16:39
 * @Description
 */
public class EquationStackTest {

    @Test
    public void fun1() {
        EquationStack equationStack = new EquationStack();
//        String calculate = equationStack.calculate("133+400*500-1000+4");
        String calculate = equationStack.calculate("5*2-1*2+3-1-4");
        System.out.println(calculate);
    }
}
