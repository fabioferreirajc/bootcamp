package org.academiadecodigo.stormrooters.histogram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HistogramInheritance extends HashMap<String,Integer> implements Iterable<String>{



    public HistogramInheritance(String phrase) {
        String[] splitedPhrase = phrase.split(" ");

        for (String word : splitedPhrase) {


            if (containsKey(word)) {
                put(word, get(word) + 1);

            } else {
                put(word, 1);
            }

        }
    }



    @Override
    public Iterator<String> iterator() {
        return keySet().iterator();
    }
}


