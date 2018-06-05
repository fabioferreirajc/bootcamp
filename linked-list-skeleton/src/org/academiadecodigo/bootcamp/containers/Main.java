package org.academiadecodigo.bootcamp.containers;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        LinkedList<Double> doubleList = new LinkedList<Double>();

        doubleList.add(0.2);
        doubleList.add(0.5);
        doubleList.add(0.5);
        doubleList.add(0.7);


        for (Double value : doubleList) {
            System.out.println(value);
        }


        /*
        Iterator it = doubleList.iterator();
        Double value;

        while (it.hasNext()) {

            value = (Double) it.next();
            System.out.println(value);
        }
        */
    }

}
