package Queue;

import Exceptions.EmptyCollectionException;
import QueueInterfaces.QueueADT;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Class that represents
 * </p>
 */
public class CircularArrayQueue<T> implements QueueADT<T> {

    /**
     * constant to represent the default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 100;

    /**
     * int that represents the start of the first element
     */
    private int front;

    /**
     * int that represents the next available position in the array
     */
    private int rear;

    /**
     * int that represents the number of elements
     */
    private int count;

    /**
     * array of generic elements to represent the queue
     */
    private T[] queue;

    /**
     * array of generic elements to represent the stack
     */
    public CircularArrayQueue() {
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
        front = 0;
        rear = 0;
        count = 0;
    }

    /**
     * Creates an empty stack using the specified capacity.
     *
     * @param size represents the specified capacity
     */
    public CircularArrayQueue(int size) {
        queue = (T[]) (new Object[size]);
        front = 0;
        rear = 0;
        count = 0;
    }

    /**
     * Expands the capacity of the array adding the DEFAULT_CAPACITY.
     */
    private void expandCapacity() {
        T[] newArray = (T[]) new Object[size() + DEFAULT_CAPACITY];
        int i = 0, temp = front;
        while (i < queue.length) {
            newArray[i] = queue[temp];
            temp = (temp + 1) % queue.length;
            i++;
        }
        front = 0;
        rear = i + 1;
        queue = newArray;
    }

    @Override
    public void enqueue(T element) {
        if (isFull()) {
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        count++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue");
        }
        T toDequeue = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;
        return toDequeue;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Queue");
        }
        return queue[front];
    }

    private boolean isFull() {
        return (count == queue.length);
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
    public String toString() {
        String result = "";
        int i = 0, tmp = front;
        System.out.println("\n\tToString\nFront: " + queue[front]);
        while (i < size()) {
            System.out.println(i + ": " + queue[tmp]);
            tmp = (tmp + 1) % queue.length;
            i++;
        }
        return result;
    }
}
