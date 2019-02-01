package com.intflag;

import org.junit.Test;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-02-01 16:32
 * @Description
 */
public class BinarySearchTreeTest {

    @Test
    public void fun1() {
        BinarySearchTree bTree = new BinarySearchTree();
        bTree.insert(5);
        bTree.insert(7);
        bTree.insert(2);
        bTree.insert(1);
        bTree.insert(4);
        bTree.insert(8);
        bTree.insert(6);
        bTree.insert(9);
        bTree.insert(0);
        bTree.inOrder(bTree.getTree());
        System.out.println();
        System.out.println(bTree.find(15));
    }

}
