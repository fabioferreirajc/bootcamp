public class Main {
    public static void main(String[] args) {


        String phrase = "lorem ipsum dolort amet, lorem vel no agam iriure meliore, eu adipisci mandamus eos";


        UniqueWords uniqueWords = new UniqueWords();

        uniqueWords.add(phrase);


        for (String word: uniqueWords) {
            System.out.println(word);
        }



    }
}
