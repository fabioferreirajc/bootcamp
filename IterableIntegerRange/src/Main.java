public class Main {


    public static void main(String[] args) {

        IntegerRange range = new IntegerRange(3, 10);


        for (Integer number : range) {

            System.out.println(number);

        }
    }
}
