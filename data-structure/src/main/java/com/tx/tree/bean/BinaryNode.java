/*
 * 二叉树树节点数据结构
 */
package com.tx.tree.bean;

/**
 * Created by peter.
 */
public class BinaryNode<AnyType> {
    public BinaryNode(AnyType element) {
        this(element, null, null);
    }

    public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public AnyType element;
    public BinaryNode<AnyType> left;
    public BinaryNode<AnyType> right;
}
