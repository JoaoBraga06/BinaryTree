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
public class AVLNode<T> {

    protected AVLNode<T> left, right, parent;
    protected T element;
    protected int height;

    public AVLNode() {
        left = null;
        right = null;
        parent=null;
        height=
        element = null;
    }

    public AVLNode(T element) {
        left = null;
        right = null;
        parent=null;
        height=
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

    public AVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

}
