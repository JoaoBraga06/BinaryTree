/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;
import BinarySearchTree.*;


/**
 *
 * @author joaop
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedAVLTree<Integer> teste = new LinkedAVLTree<>();
        
        teste.addElement(10);
        teste.addElement(8);
        teste.addElement(11);
        teste.addElement(12);
        teste.addElement(9);
        teste.addElement(7);
        teste.addElement(6);
        teste.addElement(6);

        
        System.out.println(teste.toString());
        
        
    }
    
}
