import java.util.Iterator;

public class RangeIterator implements Iterator {

    private int min;
    private int max;

    public RangeIterator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean hasNext() {
        if (min >= max) {
            System.out.println("min = max");
            return false;
        }
        return true;

    }

    @Override
    public Integer next() {

        min+=1;
        return min;

    }


}
