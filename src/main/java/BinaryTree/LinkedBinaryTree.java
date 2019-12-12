/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

import Exceptions.EmptyCollectionException;
import Exceptions.NotFoundException;
import Node.BinaryTreeNode;
import java.util.Iterator;
import ListADT.*;
import Queue.LinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaop
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;
    protected BinaryTreeNode<T> root;

    public LinkedBinaryTree() {
        count = 0;
        root = null;
    }

    public LinkedBinaryTree(T element) {
        count = 0;
        root = new BinaryTreeNode<>(element);
    }

    @Override
    public T getRoot() {
        return this.root.getElement();
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
        Comparable<T> temp = (Comparable<T>) find(targetElement);
        return (temp.compareTo(targetElement) == 0);
    }

    @Override
    public T find(T targetElement) throws NotFoundException {
        BinaryTreeNode<T> current = findAgain(targetElement, root);

        if (current == null) {
            throw new NotFoundException("binary tree");
        }

        return (current.getElement());
    }

    private BinaryTreeNode<T> findAgain(T targetElement,
            BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.getElement().equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(targetElement, next.getLeft());

        if (temp == null) {
            temp = findAgain(targetElement, next.getRight());
        }

        return temp;
    }

    @Override
    public String toString() {
        String result = "";
        try {
            Iterator<T> it = this.iteratorLevelOrder();
            while (it.hasNext()) {
                result += it.next().toString() +" ";
            }
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(LinkedBinaryTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        UnorderedListADT<T> tempList = new UnorderedListADT<T>();
        inorder(root, tempList);

        return tempList.iterator();
    }

    protected void inorder(BinaryTreeNode<T> node,
            UnorderedListADT<T> tempList) {
        if (node != null) {
            inorder(node.getLeft(), tempList);
            tempList.addToRear(node.getElement());
            inorder(node.getRight(), tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        UnorderedListADT<T> tempList = new UnorderedListADT<>();
        preOrder(root, tempList);
        return tempList.iterator();
    }

    protected void preOrder(BinaryTreeNode<T> node, UnorderedListADT<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.getElement());
            preOrder(node.getLeft(), tempList);
            preOrder(node.getRight(), tempList);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        UnorderedListADT<T> tempList = new UnorderedListADT<>();
        preOrder(root, tempList);
        return tempList.iterator();
    }

    public void postOrder(BinaryTreeNode<T> node, UnorderedListADT<T> tempList) {
        if (node != null) {
            postOrder(node.getLeft(), tempList);
            postOrder(node.getRight(), tempList);
            tempList.addToRear(node.getElement());
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException {
        UnorderedListADT<T> tempList = new UnorderedListADT<>();
        LevelOrder(root, tempList);

        return tempList.iterator();
    }

    public void LevelOrder(BinaryTreeNode<T> node, UnorderedListADT<T> tempList) throws EmptyCollectionException {
        LinkedQueue<BinaryTreeNode<T>> queue = new LinkedQueue();
        queue.enqueue(node);

        if (node != null) {
            while (!queue.isEmpty()) {
                BinaryTreeNode temp = (BinaryTreeNode) queue.dequeue();
                tempList.addToRear((T) temp.getElement());
                if (temp.numChildren() != 0) {
                    if (temp.getLeft() != null) {
                        queue.enqueue(temp.getLeft());
                    }
                    if (temp.getRight() != null) {
                        queue.enqueue(temp.getRight());
                    }
                }
            }
        }
    }
}
