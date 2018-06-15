import java.util.Iterator;

public class RangeList implements Iterable<Integer> {

    private int min;
    private int max;
    private boolean order = false;

    public RangeList(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    public Iterator<Integer> iterator() {

        if (order == false) {
            System.out.println("ORDEM CRESCENTE");


            return new Iterator<Integer>() {
                private int localMin= min -1;
                @Override
                public boolean hasNext() {

                    if (localMin >= max) {
                        return false;
                    }
                    return true;
                }

                @Override
                public Integer next() {

                    localMin += 1;
                    return localMin;
                }
            };
        }


            System.out.println("ORDEM DECRESCENTE");
            return new Iterator<Integer>() {
                private int localMax = max + 1;
                @Override
                public boolean hasNext() {

                    if (min >= localMax) {
                        return false;
                    }
                    return true;
                }

                @Override
                public Integer next() {

                    localMax -= 1;
                    return localMax;
                }
            };



    }


}




