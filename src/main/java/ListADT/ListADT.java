/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListADT;

import ListADT_Interfaces.*;
import java.util.Iterator;
import Exceptions.*;

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
 * Class that represents a Array List.
 * </p>
 *
 * @param <T>
 */
public class ListADT<T> implements ListADT_Interface<T> {

    private final int DEFAULT_CAPACITY = 100;
    private final int EXPAND_DEFAULT = 10;
    private final int NOT_FOUND = -1;

    protected T[] arrayList;
    protected int rear;
    protected int modCount;

    public class BasicIterator<T> implements Iterator<T> {

        private int expectedModcount;
        private int count;

        public BasicIterator() {
            expectedModcount = modCount;
            count = 0;
        }

        @Override
        public boolean hasNext() {
            try {
                if (expectedModcount != modCount) {
                    throw new CurrentModificationException("Error");
                }
            } catch (CurrentModificationException ex) {
            }
            return (arrayList[count] != null);
        }

        @Override
        public T next() {
            try {
                if (expectedModcount != modCount) {
                    throw new CurrentModificationException("Error");
                }
            } catch (CurrentModificationException ex) {
            }
            return (T) arrayList[count++];
        }
    }    
    
    public ListADT() {
        arrayList = (T[]) new Object[DEFAULT_CAPACITY];
        rear = -1;
        modCount = 0;
    }

    public ListADT(int initalSize) {
        arrayList = (T[]) new Object[initalSize];
        rear = -1;
        modCount = 0;
    }


    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) 
            throw new EmptyCollectionException();
        T temp = arrayList[0];
        for (int i = 0; i < this.size() - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[rear] = null;
        rear--;
        modCount++;

        return temp;
    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        T temp = arrayList[rear];
        arrayList[rear] = null;
        rear--;
        modCount++;
        return temp;
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, NotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        if (!contains(element)) {
            throw new NotFoundException();
        }
        for (int i = find(element); i < size() - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[rear] = null;
        rear--;
        modCount++;
        return element;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return arrayList[0];
    }

    @Override
    public T last() throws EmptyCollectionException{
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        return arrayList[rear];
    }

    @Override
    public boolean contains(T target) {
        return (find(target) != NOT_FOUND);
    }

    @Override
    public boolean isEmpty() {
        return (rear == 0);
    }

    @Override
    public int size() {
        return (rear + 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator<>();
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size(); i++) {
            System.out.println("Position "+i+": "+arrayList[i]);
            result += arrayList[i];
        }
        return result;
    }

    protected int find(T element) {
        int i = 0;
        int n = -1;
        boolean found = false;
        while (!found && i < size()) {
            if (element.equals(arrayList[i])) {
                found = true;
            } else {
                i++;
            }
        }
        if (i != size()) {
            n = i;
        }
        return n;
    }

    protected void expandCapacity() {
        T[] temp = (T[]) new Object[size() + EXPAND_DEFAULT];
        System.arraycopy(arrayList, 0, temp, 0, size());
        arrayList = temp;
    }
}
