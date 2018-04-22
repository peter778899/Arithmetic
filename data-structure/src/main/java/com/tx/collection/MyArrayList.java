package com.tx.collection;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType>{
    private static final int DEFAUT_CAPACITY = 10;
    private int theSize;
    private AnyType[] theItems;

    public MyArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAUT_CAPACITY);
    }

    private void ensureCapacity(int newCapacity) {
        if(newCapacity < theSize) {
            return;
        }

        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];

        for(int i = 0; i < theSize; i++) {
            theItems[i] = old[i];
        }
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return 0 == theSize;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public AnyType get(int index) {
        if(index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return theItems[index];
    }

    public AnyType set(int index, AnyType newItem) {
        if(index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        AnyType old = theItems[index];
        theItems[index] = newItem;

        return old;
    }

    public boolean add(AnyType newItem) {
        add(size(), newItem);
        return true;
    }

    public void add(int index, AnyType newItem) {
        if(index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if(theItems.length == size()) {
            ensureCapacity(size()*2 + 1);
        }

        for(int i = theSize; i > index; i--) {
            theItems[i] = theItems[i-1];
        }

        theItems[index] = newItem;
        theSize++;

    }

    public AnyType remove(int index) {
        if(index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        AnyType removedItem = theItems[index];

        for(int i = index; i < size(); i++) {
            theItems[i] = theItems[i+1];
        }

        theSize--;
        return removedItem;
    }


    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<AnyType> {
        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public AnyType next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
