/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Node;

/**
 *
 * @author joaop
 */
public class BinaryTreeNode<T> {

    protected BinaryTreeNode<T> left, right;
    protected T element;

    public BinaryTreeNode() {
        left = null;
        right = null;
        element = null;
    }

    public BinaryTreeNode(T element) {
        left = null;
        right = null;
        this.element = element;
    }

    public int numChildren() {
        int children = 0;

        if (left != null) {
            children++;
        }
        if (right != null) {
            children++;
        }
        return children;
    }


    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
