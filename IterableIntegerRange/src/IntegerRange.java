import java.util.Iterator;

public class IntegerRange implements Iterable<Integer> {

    private int min;
    private int max;

    public IntegerRange(int min, int max) {
        this.min = min-1;
        this.max = max;
    }


    @Override
    public Iterator iterator() {
        return new RangeIterator(min, max);
    }

}
 