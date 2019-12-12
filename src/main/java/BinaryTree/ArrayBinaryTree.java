/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

import Exceptions.EmptyCollectionException;
import Exceptions.NotFoundException;
import java.util.Iterator;
import ListADT.*;
import Queue.CircularArrayQueue;
import Queue.LinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaop
 */
public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;
    protected T[] tree;
    private final int CAPACITY = 50;

    public ArrayBinaryTree() {
        count = 0;
        tree = (T[]) new Object[CAPACITY];
    }

    public ArrayBinaryTree(T element) {
        count = 1;
        tree = (T[]) new Object[CAPACITY];
        tree[0] = element;
    }

    @Override
    public T getRoot() {
        return tree[0];
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(T targetElement) throws NotFoundException {
        return (targetElement.equals(find(targetElement)));
    }

    @Override
    public T find(T targetElement) throws NotFoundException {
        T temp = null;
        boolean found = false;

        for (int i = 0; i < tree.length && !found; i++) {
            if (targetElement.equals(tree[i])) {
                found = true;
                temp = tree[i];
            }
        }

        if (!found) {
            throw new NotFoundException();
        }

        return temp;
    }

    @Override
    public String toString() {
        String result = "";
        try {
            Iterator<T> it = this.iteratorLevelOrder();
            while (it.hasNext()) {
                result += it.next().toString();
            }
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(LinkedBinaryTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        UnorderedListADT<T> templist = new UnorderedListADT<>();
        inorder(0, templist);

        return templist.iterator();
    }

    protected void inorder(int node, UnorderedListADT<T> templist) {
        if (node < tree.length) {
            if (tree[node] != null) {
                inorder(node * 2 + 1, templist);
                templist.addToRear(tree[node]);
                inorder((node + 1) * 2, templist);
            }
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        UnorderedListADT<T> templist = new UnorderedListADT<>();
        inorder(0, templist);

        return templist.iterator();
    }

    protected void preorder(int node, UnorderedListADT<T> templist) {
        if (node < tree.length) {
            if (tree[node] != null) {
                templist.addToRear(tree[node]);
                inorder(node * 2 + 1, templist);
                inorder((node + 1) * 2, templist);
            }
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        UnorderedListADT<T> templist = new UnorderedListADT<>();
        inorder(0, templist);

        return templist.iterator();
    }

    protected void postorder(int node, UnorderedListADT<T> templist) {
        if (node < tree.length) {
            if (tree[node] != null) {
                inorder(node * 2 + 1, templist);
                inorder((node + 1) * 2, templist);
                templist.addToRear(tree[node]);
            }
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException {
        UnorderedListADT<T> templist = new UnorderedListADT<>();

        try {
            levelorder(0, templist);
        } catch (NotFoundException ex) {
            Logger.getLogger(ArrayBinaryTree.class.getName()).log(Level.SEVERE, null, ex);
        }

        return templist.iterator();
    }

    protected void levelorder(int node, UnorderedListADT<T> templist) throws EmptyCollectionException, NotFoundException {
        CircularArrayQueue<T> tempQueue = new CircularArrayQueue<>();
        T temp = null;
        int tempNode = node;

        if (node < tree.length) {
            if (tree[node] != null) {
                tempQueue.enqueue(tree[node]);
            }
            while (!tempQueue.isEmpty()) {
                temp = tempQueue.dequeue();
                templist.addToRear(temp);
                tempNode = findPosition(temp);
                if (tree[tempNode * 2 + 1] != null) {
                    tempQueue.enqueue(tree[node * 2 + 1]);
                }
                if (tree[(tempNode + 1) * 2] != null) {
                    tempQueue.enqueue(tree[(node + 1) * 2]);
                }
            }
        }
    }

    private int findPosition(T targetElement) throws NotFoundException {
        int temp = -1;

        for (int i = 0; i < tree.length; i++) {
            if (targetElement.equals(tree[i])) {
                temp = i;
            }
        }

        if (temp == -1) {
            throw new NotFoundException();
        }

        return temp;
    }
}
