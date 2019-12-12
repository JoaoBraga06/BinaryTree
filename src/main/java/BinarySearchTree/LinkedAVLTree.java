/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

import Node.BinaryTreeNode;

/**
 *
 * @author joaop
 */
public class LinkedAVLTree<T> extends LinkedBinarySearchTree<T>{

    int hLeft, hRight;

    public LinkedAVLTree() {
        
        hLeft = 0;
        hRight = 0;
    }


    public void rotateRight() {
          if ((hLeft - hRight) > 1) {
            this.rotateRight();
        } else if ((hLeft - hRight) < -1) {

        }
          
          
          
        BinaryTreeNode<T> temp = super.root;
        super.root = super.root.getLeft();
        temp.setLeft(super.root.getRight());
        super.root.setRight(temp);
    }

}
