package org.academiadecodigo.stormrooters.histogram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Histogram implements Iterable<String> {

    private Map<String, Integer> histogram;


    public Histogram() {
        this.histogram = new HashMap();
    }


    public void add(String phrase) {
        String[] splitedPhrase = phrase.split(" ");

        for (String word : splitedPhrase) {


            if (histogram.containsKey(word)) {
                histogram.put(word, histogram.get(word) + 1);

            } else {
                histogram.put(word, 1);
            }

        }
    }

    public Integer get(String item) {
        return histogram.get(item);
    }

    @Override
    public Iterator<String> iterator() {
        return histogram.keySet().iterator();
    }
}
