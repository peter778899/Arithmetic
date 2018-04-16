package com.tx.tree.trees;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> binarySearchTree;
    private final static int[] ELEMENTS = new int[]{12,2,3,5,1,6};

    @Before
    public void setUp() throws Exception {
        binarySearchTree = new BinarySearchTree<Integer>();
        for(int i=0;i<ELEMENTS.length;i++) {
            binarySearchTree.insert(ELEMENTS[i]);
        }
    }

    @After
    public void tearDown() throws Exception {
        binarySearchTree = null;
    }

    @Test
    public void makeEmpty() {
        binarySearchTree.makeEmpty();
        Assert.assertTrue(binarySearchTree.isEmpty());
    }

    @Test
    public void isEmpty() {
        Assert.assertFalse(binarySearchTree.isEmpty());
    }

    @Test
    public void contains() {
        Assert.assertFalse(binarySearchTree.contains(0));
        Assert.assertTrue(binarySearchTree.contains(12));
    }

    @Test
    public void findMin() throws Exception {
        Assert.assertEquals(1, binarySearchTree.findMin().intValue());
    }

    @Test
    public void findMax() throws Exception {
        Assert.assertEquals(12, binarySearchTree.findMax().intValue());
    }

    @Test
    public void insert() {
        Assert.assertFalse(binarySearchTree.contains(100));
        binarySearchTree.insert(100);
        Assert.assertTrue(binarySearchTree.contains(100));
    }

    @Test
    public void remove() {
        Assert.assertTrue(binarySearchTree.contains(12));
        binarySearchTree.remove(12);
        Assert.assertFalse(binarySearchTree.contains(12));
    }

    @Test
    public void printree() {
        binarySearchTree.printree();
    }
}