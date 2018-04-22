package com.tx.collection;

import java.util.Iterator;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> begin;
    private Node<AnyType> end;

    private static class Node<AnyType> {
        public Node(AnyType data, Node<AnyType> pre, Node<AnyType> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        public AnyType data;
        public Node<AnyType> pre;
        public Node<AnyType> next;
    }

    public MyLinkedList() {
        clear();
    }

    private void clear() {
        theSize = 0;
        modCount++;
        begin = new Node<AnyType>(null, null, null);
        end = new Node<AnyType>(null, begin, null);
        begin.next = end;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return 0 == size();
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    private void add(int index, AnyType x) {
        addBefore(getNode(index), x);
    }
    
    public AnyType get(int index) {
        return getNode(index).data;
    }

    public AnyType set(int index, AnyType newVal) {
        Node<AnyType> old = getNode(index);
        AnyType oldVal = old.data;
        old.data = newVal;

        return oldVal;
    }

    public AnyType remove(int index) {
        return remove(getNode(index));
    }

    private AnyType remove(Node<AnyType> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

        theSize--;
        modCount++;

        return node.data;
    }

    private void addBefore(Node<AnyType> node, AnyType x) {
        Node<AnyType> newNode = new Node(x, node.pre, node);
        newNode.pre.next = newNode;
        node.pre = newNode;

    }

    private Node<AnyType> getNode(int index) {
        Node<AnyType> node;

        if(index<0 || index>size()) {
            throw new IndexOutOfBoundsException();
        }

        if(index < size()/2) {
            node = begin.next;
            for(int i=0;i<index;i++) {
                node = node.next;
            }
        } else {
            node = end.pre;
            for(int i=size();i>index;i--) {
                node = node.pre;
            }
        }

        return node;
        
    }

    public Iterator<AnyType> iterator() {
        return null;
    }
}
