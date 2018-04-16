/*
 * 二叉查找树
 */
package com.tx.tree.trees;

import com.tx.tree.bean.BinaryNode;

/**
 * Created by peter.
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{
    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return null == this.root;
    }

    public boolean contains(AnyType e) {
        return contains(e, root);
    }

    public AnyType findMin() throws Exception {
        if(isEmpty()) {
            throw new Exception("Undefined");
        }

        return findMin(this.root).element;
    }

    public AnyType findMax() throws Exception {
        if(isEmpty()) {
            throw new Exception("Undefined");
        }

        return findMax(this.root).element;
    }

    public void insert(AnyType ele) {
        root = insert(ele, this.root);
    }

    public void remove(AnyType ele) {
        root = remove(ele, root);
    }

    /**
     * 功能：按大小顺序打印树节点（先序遍历）
     */
    public void printree() {
        if(isEmpty()) {
            System.out.println("Empty Tree.");
        }

        printTree(this.root);
    }

    private void printTree(BinaryNode<AnyType> root) {
        if(root != null) {
            printTree(root.left);
            System.out.println(root.element);
            printTree(root.right);
        }


    }

    /**
     * 功能：删除元素对象
     * @param ele 要被删除的元素对象
     * @param root 树根节点
     * @return 删除元素对象后新树的根节点
     */
    private BinaryNode<AnyType> remove(AnyType ele, BinaryNode<AnyType> root) {
        if(null == root) {
            return null;
        }

        int compareRes = ele.compareTo(root.element);

        if(compareRes < 0) {
            root.left = remove(ele, root.left);
        } else if(compareRes > 0) {
            root.right =  remove(ele, root.right);
        } else {
            if(null == root.left) {
                root = root.right;
            } else if(null == root.right) {
                root = root.left;
            } else {
                root.element = findMin(root.right).element;
                remove(root.element, root.right);
            }
        }

        return root;

    }

    /**
     * 功能：插入新的元素对象
     * @param ele 需要插入的元素对象
     * @param root 子树根节点
     * @return 根节点
     */
    private BinaryNode<AnyType> insert(AnyType ele, BinaryNode<AnyType> root) {
        if(null == root) {
            return new BinaryNode<AnyType>(ele, null, null);
        }

        int compareRes = ele.compareTo(root.element);

        if(compareRes < 0) {
            root.left = insert(ele, root.left);
        }else if(compareRes > 0) {
            root.right = insert(ele, root.right);
        }

        return root;
    }

    /**
     * 功能：查找子树中的最大值
     * @param root 子树根节点
     * @return 有最大值的节点
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> root) {
        if (root != null) {
            while (root.right != null) {
                root = root.right;
            }
        }

        return root;
    }

    /**
     * 功能：查找子树中的最小值
     * @param root 子树根节点
     * @return 有最小值的节点
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> root) {
        if(null == root.left) {
            return root;
        }

        return findMin(root.left);
    }

    /**
     * 功能：判断是否树是否包含要查找的元素对象
     * @param e 需要查找的元素对象
     * @param root 子树根节点
     * @return boolean类型结果
     */
    private boolean contains(AnyType e, BinaryNode<AnyType> root) {
        if(null == root) {
            return false;
        }

        int compareRes = e.compareTo(root.element);

        if(compareRes < 0) {
            return contains(e,root.left);
        }

        if(compareRes > 0) {
            return contains(e,root.right);
        }

        return true;
    }
}
