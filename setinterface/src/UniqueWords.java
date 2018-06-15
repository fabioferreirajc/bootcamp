import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords implements Iterable<String> {

    //private String string;
    private Set<String> words;

    public UniqueWords() {
        this.words = new TreeSet<>();
        //this.string=string;

    }


    public void add(String phrase) {
        String[] splitedString = phrase.split(" ");
        for (String wordFromArray : splitedString) {
            words.add(wordFromArray);
        }

    }


    @Override
    public Iterator<String> iterator() {

        return words.iterator();
    }


}
