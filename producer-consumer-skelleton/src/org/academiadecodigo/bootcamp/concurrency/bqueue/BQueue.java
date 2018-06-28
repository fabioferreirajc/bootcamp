package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;

/**
 * Blocking Queue
 *
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private LinkedList<T> queueList;
    private int limit;



    /**
     * Constructs a new queue with a maximum size
     *
     * @param limit the queue size
     */
    public BQueue(int limit) {
        this.limit = limit;
        this.queueList= new LinkedList();

        //throw new UnsupportedOperationException();

    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     *
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) {

        while (queueList.size() == limit) {
            try {
                System.out.println("PRODUCER: wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        queueList.offer(data);
        System.out.println("PRODUCER: add");
        notifyAll();
        //throw new UnsupportedOperationException();

    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     *
     * @return the data from the head of the queue
     */
    public synchronized T poll() {
        while (queueList.isEmpty()) {
            try {
                System.out.println("CONSUMER: wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("CONSUMER: retrieve");
        notifyAll();
        return queueList.poll();
    }

    /**
     * Gets the number of elements in the queue
     *
     * @return the number of elements
     */
    public int getSize() {
        return queueList.size();
        //throw new UnsupportedOperationException();

    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     *
     * @return the maximum number of elements
     */
    public int getLimit() {
        return limit;
        //throw new UnsupportedOperationException();

    }

}
