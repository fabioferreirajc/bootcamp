package org.academiadecodigo.bootcamp.containers;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node head;
    private int length = 0;

    public LinkedList() {
        this.head = new Node(null);
    }

    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }


    /**
     * Adds an element to the end of the list
     *
     * @param data the element to add
     */
    public void add(T data) {

        Node node = new Node(data);
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        iterator.setNext(node);
        length++;

    }

    /**
     * Obtains an element by index
     *
     * @param index the index of the element
     * @return the element
     */
    public T get(int index) {

        int indexOfNode = 0;
        Node iterator = head.getNext();

        while (iterator != null) {
            if (index == indexOfNode) {
                return iterator.getData();
            }

            iterator = iterator.getNext();
            indexOfNode++;

        }
        return null;
//        throw new UnsupportedOperationException();
    }

    /**
     * Returns the index of the element in the list
     *
     * @param data element to search for
     * @return the index of the element, or -1 if the list does not contain element
     */
    public int indexOf(T data) {
        int indexOfNode = 0;
        Node iterator = head.getNext();

        while (iterator != null) {

            if (data == iterator.getData()) {
                return indexOfNode;
            }
            iterator = iterator.getNext();
            indexOfNode++;
        }
        return -1;
    }

    /**
     * Removes an element from the list
     *
     * @param data the element to remove
     * @return true if element was removed
     */
    public boolean remove(T data) {
        Node iterator = head;
        Node remove = head.getNext();

        while (iterator.getNext() != null) {
            if (data == remove.getData()) {
                iterator.setNext(remove.getNext());
                length--;
                return true;
            }
            iterator = iterator.getNext();
            remove = remove.getNext();


        }
        return false;
        //throw new UnsupportedOperationException();

    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private class MyIterator implements Iterator<T> {



        @Override
        public boolean hasNext() {
            if (head==null) {
                return false;
            }
            return true ;
        }

        @Override
        public T next() {


        }

    }

}


