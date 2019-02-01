package com.intflag;

import java.nio.file.NotLinkException;

/**
 * @author liugx  QQ:1598749808
 * @version V1.0
 * @date 2019-02-01 16:18
 * @Description 二叉查找树
 */
public class BinarySearchTree {

    private Node tree;

    public Node getTree() {
        return tree;
    }

    /**
     * 中序遍历
     *
     * @param tree
     */
    public void inOrder(Node tree) {
        if (tree == null) {
            return;
        }
        inOrder(tree.left);
        System.out.print(tree.data + " ");
        inOrder(tree.right);
    }

    /**
     * 插入数据
     *
     * @param data
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else if (data < p.data) {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }

        }
    }

    public Node delete(int data) {
        return null;
    }

    /**
     * 查找数据
     * @param data
     * @return
     */
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
