/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListADT;
import ListADT_Interfaces.UnorderedListADT_Interface;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * ED - Estrutura de Dados<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Brito<br>
 * <strong>Description: </strong><br>
 * Class that represents a Array Unordered List.
 * </p>
 *
 * @param <T>
 */
public class UnorderedListADT<T> extends ListADT<T> implements UnorderedListADT_Interface<T>{

    public UnorderedListADT() {
        super();
    }

    public UnorderedListADT(int initialSize) {
        super(initialSize);
    }
    
    @Override
    public void addToFront(T element) {
        if(super.size()==arrayList.length)
            super.expandCapacity();
        T[] temp=(T[]) new Object[arrayList.length];
        System.arraycopy(arrayList, 0, temp, 1, super.size());
        temp[0]=element;
        arrayList=temp;
        rear++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        if(super.size()==arrayList.length)
            super.expandCapacity();
        arrayList[size()]=element;
        rear++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T elementToAdd) {
        if(super.size()==arrayList.length)
            super.expandCapacity();
        for(int i=size();i>super.find(element)+1;i--)
            arrayList[i]=arrayList[i-1];
        arrayList[find(element)+1]=elementToAdd;
        rear++;
        modCount++;
    }
    
}
