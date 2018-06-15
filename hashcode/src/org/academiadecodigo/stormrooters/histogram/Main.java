package org.academiadecodigo.stormrooters.histogram;

public class Main {
    public static void main(String[] args) {

        String text = "lorem ipsum dolort amet, lorem vel no agam iriure meliore, eu adipisci mandamus eos";

        Histogram histogram = new Histogram();
        histogram.add(text);

        for (String item: histogram) {
            System.out.println(item + " "+ histogram.get(item));
        }



        HistogramInheritance histogramInheritance = new HistogramInheritance(text);

        for (String item: histogramInheritance) {
            System.out.println(item + " " + histogramInheritance.get(item));

        }

    }
}
